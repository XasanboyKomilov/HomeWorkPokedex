package com.example.pokedex

import java.io.Serializable

data class PokemonModel (
    val number: String,
    val name: String,
    val hp: Int
): Serializable