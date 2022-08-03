package com.example.com.example.config

import com.example.com.example.controller.*
import io.vertx.core.Vertx
import io.vertx.ext.auth.oauth2.OAuth2FlowType
import io.vertx.ext.auth.oauth2.OAuth2Options
import io.vertx.ext.auth.oauth2.providers.KeycloakAuth
import io.vertx.ext.web.Router
import io.vertx.ext.web.client.WebClient
import io.vertx.ext.web.handler.OAuth2AuthHandler
import io.vertx.ext.web.templ.thymeleaf.ThymeleafTemplateEngine
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order

@Configuration
@Order(2)
open class VertxConfig {

    @Bean
    open fun getVertx() = Vertx.vertx()

    @Value("\${oauth2.issuer}")
    private lateinit var REALM: String

    @Value("\${oauth2.client_id}")
    private lateinit var CLIENT: String

    @Value("\${oauth2.client_secret}")
    private lateinit var CLIENT_SECRET: String

    @Bean
    open fun getRouter(
        vertx: Vertx,
        webClientService: WebClientService,
        templateEngine: ThymeleafTemplateEngine,
        stubService: StubService
    ): Router {
        return Router.router(vertx).apply {
            get("/all").handler(FreeButtonHandler(webClientService,templateEngine))
            KeycloakAuth.discover(
                vertx,
                OAuth2Options()
                    .setFlow(OAuth2FlowType.AUTH_CODE)
                    .setSite(System.getProperty("oauth2.issuer", REALM))
                    .setClientID(System.getProperty("oauth2.client_id", CLIENT))
                    .setClientSecret(System.getProperty("oauth2.client_secret", CLIENT_SECRET))
            )
                .onSuccess {
                    val oauth2 = OAuth2AuthHandler.create(vertx, it, "http://localhost:8081/callback")
                        .setupCallback(get("/callback"))
                    get("/").handler(LoginHandler())
                    get("/start").handler(oauth2).handler(IndexHandler())
                    get("/click").handler(oauth2)
                        .handler(ButtonClickHandler(templateEngine, stubService, webClientService))
                }
                .onFailure {
                    System.out.println("Error with keycloack")
                }
        }
    }

    @Bean
    open fun getTemplateEngine(vertx: Vertx) = ThymeleafTemplateEngine.create(vertx)

    @Bean
    open fun getClient(vertx: Vertx) = WebClient.create(vertx)

    @Bean
    open fun server(router: Router, vertx: Vertx) = vertx.createHttpServer()
        .requestHandler(router)

}