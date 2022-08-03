package com.example.com.example.controller

import com.example.com.example.model.PokemonsResponse
import com.example.model.Pokemon
import io.vertx.core.Future
import io.vertx.core.buffer.Buffer
import io.vertx.core.http.HttpMethod
import io.vertx.core.json.JsonArray
import io.vertx.core.json.JsonObject
import io.vertx.ext.web.client.HttpResponse
import io.vertx.ext.web.client.WebClient
import io.vertx.ext.web.codec.BodyCodec
import io.vertx.kotlin.coroutines.await
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class WebClientService(private var webClient: WebClient) {

    @Value("\${pokeapi_base_url}")
    private lateinit var BASE_URL: String

    fun getPokemon(pokemonId: String): Future<HttpResponse<Pokemon>> {
        return webClient.requestAbs(
            HttpMethod.GET, BASE_URL + pokemonId
        )
            .`as`(BodyCodec.json(Pokemon::class.java))
            .send()
    }

    fun getAllPokemons(): Future<HttpResponse<PokemonsResponse>> {
        return webClient.requestAbs(
            HttpMethod.GET, BASE_URL + "?limit=100"
        )
            .`as`(BodyCodec.json(PokemonsResponse::class.java))
            .send()
    }
}