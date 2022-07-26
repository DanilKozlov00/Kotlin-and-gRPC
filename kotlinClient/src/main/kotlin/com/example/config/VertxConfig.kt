package com.example.com.example.config

import com.example.KotlinServiceGrpc
import com.example.SendMessage
import com.example.com.example.controller.ButtonClickHandler
import com.example.com.example.controller.IndexHandler
import com.example.model.Pokemon
import io.vertx.core.Vertx
import io.vertx.core.http.HttpHeaders
import io.vertx.core.http.HttpMethod
import io.vertx.core.json.Json
import io.vertx.ext.web.Router
import io.vertx.ext.web.client.WebClient
import io.vertx.ext.web.codec.BodyCodec
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

            get("/").handler(IndexHandler())

            get("/click").handler(ButtonClickHandler(webClient, templateEngine, stub))

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