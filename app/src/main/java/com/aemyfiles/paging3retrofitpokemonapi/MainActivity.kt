package com.aemyfiles.paging3retrofitpokemonapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.paging3retrofitpokemonapi.MainViewModel
import com.example.paging3retrofitpokemonapi.MainViewModelFactory
import com.example.paging3retrofitpokemonapi.adapter.PokemonAdapter
import com.example.paging3retrofitpokemonapi.domain.APIService
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        testResult()
        setupViewModel()
        setupView()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this, MainViewModelFactory(APIService.getApiService()))[MainViewModel::class.java]
    }

    private fun setupView() {
        val pokemonAdapter = PokemonAdapter()
        recyclerViewPokemon.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = pokemonAdapter
        }

        lifecycleScope.launch {
            viewModel.listPokemon.collect {
                pokemonAdapter.submitData(it)
            }
        }

    }

    private fun testResult() {
        val connect = APIService.getApiService()
        CoroutineScope(Dispatchers.IO).launch {
//            val response = connect.getListPokemon(0, 100)
            val response = connect.getDetailByName("bulbasaur")
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    Log.d("hai.bui1", "testGet: success")
                } else {
                    Log.d("hai.bui1", "testGet: fail")
                }
            }
        }
    }
}