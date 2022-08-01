package com.example.com.example.controller

import com.example.model.Pokemon
import io.vertx.core.Handler
import io.vertx.ext.web.RoutingContext
import io.vertx.ext.web.templ.thymeleaf.ThymeleafTemplateEngine
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.Continuation

class ButtonClickHandler(
    private val templateEngine: ThymeleafTemplateEngine,
    private val stubService: StubService,
    private val webClientService: WebClientService
) :
    Handler<RoutingContext> {

    override fun handle(event: RoutingContext) {
        webClientService.getPokemon(event.request().getParam("number")).onSuccess {
            val pokemons = stubService.sendMessage(it.body())
            event.data()["pokemon"] = it.body()
            event.data()["pokemons"] = pokemons
            event.response()
                .send(
                    templateEngine.render(
                        event.data(),
                        "src/main/webapp/pokemon.jsp"
                    ).result()
                )
        }
            .onFailure {
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

