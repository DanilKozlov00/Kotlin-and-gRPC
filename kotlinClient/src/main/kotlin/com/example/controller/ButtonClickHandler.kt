package com.example.com.example.controller

import io.vertx.core.Handler
import io.vertx.ext.web.RoutingContext
import io.vertx.ext.web.templ.thymeleaf.ThymeleafTemplateEngine
import io.vertx.kotlin.coroutines.await
import kotlinx.coroutines.*

class ButtonClickHandler(
    private val templateEngine: ThymeleafTemplateEngine,
    private val stubService: StubService,
    private val webClientService: WebClientService
) :
    Handler<RoutingContext> {

    override fun handle(event: RoutingContext) {
        GlobalScope.launch {
            val pokemon = webClientService.getPokemon(event.request().getParam("number")).await().body()
            val pokemons = stubService.sendMessage(pokemon)
            event.data()["pokemon"] = pokemon
            event.data()["pokemons"] = pokemons
            event.response()
                .send(
                    templateEngine.render(
                        event.data(),
                        "src/main/webapp/protectedPokemon.jsp"
                    ).result()
                ).onFailure {
                    event.data()["error"] = it.message
                    event.response()
                        .send(
                            templateEngine.render(
                                event.data(),
                                "src/main/webapp/error.jsp"
                            ).result()
                        )
                }

        }
    }
}


