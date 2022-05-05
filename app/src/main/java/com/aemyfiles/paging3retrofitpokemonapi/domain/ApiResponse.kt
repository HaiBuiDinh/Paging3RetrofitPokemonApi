package com.example.paging3retrofitpokemonapi.domain

import com.squareup.moshi.Json

data class ApiResponse(
    @Json(name = "results")
    val listPokemon: List<Pokemon>
)