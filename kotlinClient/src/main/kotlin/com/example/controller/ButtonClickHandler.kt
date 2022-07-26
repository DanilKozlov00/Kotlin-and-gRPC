package com.example.com.example.controller

import com.example.KotlinServiceGrpc
import com.example.SendMessage
import com.example.model.Pokemon
import io.vertx.core.Handler
import io.vertx.core.http.HttpMethod
import io.vertx.ext.web.RoutingContext
import io.vertx.ext.web.client.WebClient
import io.vertx.ext.web.codec.BodyCodec
import io.vertx.ext.web.templ.thymeleaf.ThymeleafTemplateEngine

class ButtonClickHandler(
    private val webClient: WebClient,
    private val templateEngine: ThymeleafTemplateEngine,
    private val stub: KotlinServiceGrpc.KotlinServiceBlockingStub
) :
    Handler<RoutingContext> {

    override fun handle(event: RoutingContext) {
        webClient.requestAbs(
            HttpMethod.GET,
            "https://pokeapi.co/api/v2/pokemon/${event.request().getParam("number")}"
        ).`as`(BodyCodec.json(Pokemon::class.java))
            .send()
            .onSuccess {

                val pokemon = it.body()

                event.data()["pokemon"] = pokemon

                val response = mutableListOf<Pokemon>()

                stub.sendMessage(
                    SendMessage.PokemonMessage.newBuilder()
                        .setId(pokemon.id)
                        .setName(pokemon.name)
                        .setWeight(pokemon.weight)
                        .setHeight(pokemon.height)
                        .setBaseExperience(pokemon.base_experience)
                        .setImage(pokemon.image)
                        .build()
                ).forEach {
                    response.add(
                        Pokemon(
                            it.baseExperience,
                            it.height,
                            it.id,
                            it.name,
                            it.weight,
                            it.image
                        )
                    )
                }

                event.data()["pokemons"] = response
                event.response()
                    .send(
                        templateEngine.render(
                            event.data(),
                            "src/main/webapp/pokemon.jsp"
                        ).result()
                    )
            }
            .onFailure {
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
