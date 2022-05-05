package com.example.paging3retrofitpokemonapi.domain.detailpokemon

import com.squareup.moshi.Json

data class DetailPokemon(
    @Json(name = "abilities")
    val listAbility: List<Abilities>,
    @Json(name = "base_experience")
    val base_experience: Int,
    @Json(name = "forms")
    val listFrom: List<Form>,
    @Json(name = "height")
    val height: Int,
    @Json(name = "id")
    val id: Int,
    @Json(name = "location_area_encounters")
    val location_area_encounters: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "sprites")
    val sprites: Sprite,
    @Json(name = "weight")
    val weight: Int
)

data class Abilities(
    @Json(name = "ability")
    val ability: SubAbility,
    @Json(name = "is_hidden")
    val is_hidden: Boolean,
    @Json(name = "slot")
    val slot: Int
)

data class SubAbility(
    @Json(name = "name")
    val name: String,
    @Json(name = "url")
    val url: String
)

data class Form(
    @Json(name = "name")
    val name: String,
    @Json(name = "url")
    val url: String
)

data class Sprite(
    @Json(name = "back_default")
    val back_default: String?,
    @Json(name = "back_female")
    val back_female: String?,
    @Json(name = "back_shiny")
    val back_shiny: String?,
    @Json(name = "back_shiny_female")
    val back_shiny_female: String?,
    @Json(name = "front_default")
    val front_default: String?,
    @Json(name = "front_female")
    val front_female: String?,
    @Json(name = "front_shiny")
    val front_shiny: String?,
    @Json(name = "front_shiny_female")
    val front_shiny_female: String?
)
