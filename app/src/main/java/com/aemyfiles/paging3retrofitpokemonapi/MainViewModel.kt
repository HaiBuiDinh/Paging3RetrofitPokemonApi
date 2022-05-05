package com.example.paging3retrofitpokemonapi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.paging3retrofitpokemonapi.datasource.PostDataSource
import com.example.paging3retrofitpokemonapi.domain.APIService

class MainViewModel(private val apiService: APIService): ViewModel() {

    val listPokemon = Pager(PagingConfig(pageSize = 14)) {
        PostDataSource(apiService)
    }.flow.cachedIn(viewModelScope)
}