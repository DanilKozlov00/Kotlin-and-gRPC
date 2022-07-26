package com.example.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Pokemon(
    val base_experience: Int,
    val height: Int,
    val id: Int,
    val name: String,
    val weight: Int,
    val image: String = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$id.png"
)