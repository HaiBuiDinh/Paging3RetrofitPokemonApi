package com.example.paging3retrofitpokemonapi.domain

import com.squareup.moshi.Json

data class Pokemon(
    @Json(name = "name")
    val name: String,
    @Json(name = "url")
    val url: String,
    var icon_url: String?
)
