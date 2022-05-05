package com.example.paging3retrofitpokemonapi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.aemyfiles.paging3retrofitpokemonapi.R
import com.bumptech.glide.Glide
import com.example.paging3retrofitpokemonapi.domain.Pokemon
import kotlinx.android.synthetic.main.item_pokemon_layout.view.*

class PokemonAdapter: PagingDataAdapter<Pokemon, PokemonAdapter.ViewHolder>(DataDiff) {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view)

    object DataDiff: DiffUtil.ItemCallback<Pokemon>() {
        override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem == newItem
        }

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let {
            holder.itemView.pokemonName.text = it.name
            holder.itemView.pokemonUrl.text = it.url
            if (it.icon_url != null) {
                Glide.with(holder.itemView.context).load(it.icon_url).into(holder.itemView.thumbnail_pokemon)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon_layout, parent, false))
    }
}