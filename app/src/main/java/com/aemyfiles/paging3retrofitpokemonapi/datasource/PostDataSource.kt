package com.example.paging3retrofitpokemonapi.datasource

import androidx.paging.PagingSource
import com.example.paging3retrofitpokemonapi.domain.APIService
import com.example.paging3retrofitpokemonapi.domain.Pokemon

class PostDataSource(private val apiService: APIService): PagingSource<Int, Pokemon>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Pokemon> {
        try {
            val currentLoadingPageKey = params.key ?: 0
            val response = apiService.getListPokemon(currentLoadingPageKey, 20)
            val responseData = mutableListOf<Pokemon>()
            val data = response.body()?.listPokemon ?: emptyList()
            if (data.isNotEmpty()) {
                for(i in 0..data.size-1) {
                    val responseDetail = apiService.getDetailByName(data[i].name)
                    val dataIcon = responseDetail.body()?.sprites?.front_default.toString()
                    data[i].icon_url = dataIcon
                }
            }
            responseData.addAll(data)

            val prevKey = if (currentLoadingPageKey == 0) null else currentLoadingPageKey - 20
            return LoadResult.Page(
                data = responseData,
                prevKey = prevKey,
                nextKey = if (data.size < 20 || data.isEmpty()) null else currentLoadingPageKey.plus(20)
            )

        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }
}