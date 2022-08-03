package com.example.com.example.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)

data class PokemonsResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<PokemonInfo>
)

data class PokemonInfo(
    val name: String,
    val url: String
)