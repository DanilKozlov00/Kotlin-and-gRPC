package com.example.com.example.config

import com.example.KotlinServiceGrpc
import com.example.com.example.controller.ButtonClickHandler
import com.example.com.example.controller.IndexHandler
import com.example.com.example.controller.LoginHandler
import io.vertx.core.Vertx
import io.vertx.ext.auth.oauth2.OAuth2FlowType
import io.vertx.ext.auth.oauth2.OAuth2Options
import io.vertx.ext.auth.oauth2.providers.KeycloakAuth
import io.vertx.ext.web.Router
import io.vertx.ext.web.client.WebClient
import io.vertx.ext.web.handler.OAuth2AuthHandler
import io.vertx.ext.web.templ.thymeleaf.ThymeleafTemplateEngine
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order

@Configuration
@Order(2)
open class VertxConfig {

    @Bean
    open fun getVertx() = Vertx.vertx()

    @Bean
    open fun getRouter(
        vertx: Vertx,
        webClient: WebClient,
        templateEngine: ThymeleafTemplateEngine,
        stub: KotlinServiceGrpc.KotlinServiceBlockingStub
    ): Router {
        return Router.router(vertx).apply {
            KeycloakAuth.discover(
                vertx,
                OAuth2Options()
                    .setFlow(OAuth2FlowType.AUTH_CODE)
                    .setSite(System.getProperty("oauth2.issuer", "http://localhost:8080/auth/realms/test"))
                    .setClientID(System.getProperty("oauth2.client_id", "test"))
                    .setClientSecret(System.getProperty("oauth2.client_secret", "vXFxVdSslINGg93rrqpWrIguOWHJ7Jd4"))
            )
                .onSuccess {
                    val oauth2 = OAuth2AuthHandler.create(vertx, it, "http://localhost:8081/callback")
                        .setupCallback(get("/callback"))
                    get("/").handler(LoginHandler())
                    get("/start").handler(oauth2).handler(IndexHandler())
                    get("/click").handler(oauth2).handler(ButtonClickHandler(webClient, templateEngine, stub))
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