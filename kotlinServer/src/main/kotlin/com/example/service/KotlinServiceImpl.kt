package com.example.com.example.service

import com.example.KotlinServiceGrpc
import com.example.SendMessage
import com.example.model.Pokemon
import io.grpc.stub.StreamObserver
import java.time.Instant

class KotlinServiceImpl : KotlinServiceGrpc.KotlinServiceImplBase() {

    private val pokemons = mutableListOf<Pokemon>()

    override fun sendMessage(
        request: SendMessage.PokemonMessage,
        responseObserver: StreamObserver<SendMessage.PokemonResponseMessage>?
    ) {
        pokemons.add(
            Pokemon(
                request.baseExperience,
                request.height,
                request.id,
                request.name,
                request.weight,
                request.image
            )
        )

        for (pokemon in pokemons) {
            responseObserver?.onNext(
                SendMessage.PokemonResponseMessage.newBuilder()
                    .setId(pokemon.id)
                    .setHeight(pokemon.height)
                    .setWeight(pokemon.weight)
                    .setImage(pokemon.image)
                    .setName(pokemon.name)
                    .setBaseExperience(pokemon.base_experience)
                    .setPayload("Success").setTime("${Instant.now()}")
                    .build()
            )
        }
        responseObserver?.onCompleted()
    }


}