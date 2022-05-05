package com.example.paging3retrofitpokemonapi.domain

import com.example.paging3retrofitpokemonapi.domain.detailpokemon.DetailPokemon
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface APIService {
    @GET("pokemon")
    suspend fun getListPokemon(@Query("offset") offset: Int, @Query("limit") limit: Int): Response<ApiResponse>


    @GET("pokemon/{name}")
    suspend fun getDetailByName(@Path("name") name: String): Response<DetailPokemon>

    companion object {
        private val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory()).build()

        fun getApiService() = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(APIService::class.java)
    }
}