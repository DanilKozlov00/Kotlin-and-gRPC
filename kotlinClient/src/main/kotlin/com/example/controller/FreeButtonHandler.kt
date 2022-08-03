package com.example.com.example.controller

import com.example.model.Pokemon
import io.vertx.core.Handler
import io.vertx.ext.web.RoutingContext
import io.vertx.ext.web.templ.thymeleaf.ThymeleafTemplateEngine
import io.vertx.kotlin.coroutines.await
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class FreeButtonHandler(
    private val webClientService: WebClientService,
    private val templateEngine: ThymeleafTemplateEngine
) :
    Handler<RoutingContext> {
    override fun handle(event: RoutingContext) {
        GlobalScope.launch {
            val pokemons = webClientService.getAllPokemons().await().body()
            val result: MutableList<Pokemon> = mutableListOf()
            pokemons.results.forEach {
                result.add(
                    webClientService.getPokemon(
                        it.url.replace("https://pokeapi.co/api/v2/pokemon/", "").replace("/", "")
                    ).await().body()
                )
            }
            event.data()["pokemons"] = result
            event.response()
                .send(
                    templateEngine.render(
                        event.data(),
                        "src/main/webapp/freePokemons.jsp"
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