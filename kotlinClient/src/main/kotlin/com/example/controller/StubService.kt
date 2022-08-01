package com.example.com.example.controller

import com.example.KotlinServiceGrpc.KotlinServiceBlockingStub
import com.example.SendMessage
import com.example.model.Pokemon
import org.springframework.stereotype.Component

@Component
class StubService(private val stub: KotlinServiceBlockingStub) {

    fun sendMessage(pokemon: Pokemon): List<Pokemon> {
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
        )
            .forEach {
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
        return response
    }

}