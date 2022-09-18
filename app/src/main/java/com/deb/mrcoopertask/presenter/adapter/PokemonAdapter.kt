package com.deb.mrcoopertask.presenter.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.deb.mrcoopertask.data.model.ResponseGender.PokemonSpecies
import com.deb.mrcoopertask.data.model.ResponseGender.PokemonSpeciesDetail
import com.deb.mrcoopertask.databinding.PokemonSingleItemBinding

class PokemonAdapter() : ListAdapter<PokemonSpeciesDetail, PokemonAdapter.PokemonViewHolder>(
    DiffCallback()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
     val binding = PokemonSingleItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PokemonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }

    inner  class PokemonViewHolder(private val binding: PokemonSingleItemBinding) : RecyclerView.ViewHolder(binding.root){
        init { }
        fun bind(pokemonSpeciesDetail: PokemonSpeciesDetail) {
            binding.apply {
                PokemonName.text = pokemonSpeciesDetail.pokemon_species.name
                binding.root.setOnClickListener {
                    onItemClickListener?.let {
                        it(pokemonSpeciesDetail)
                    }
                }
            }
        }
    }

    private var onItemClickListener :((PokemonSpeciesDetail)->Unit)?=null

    fun setOnItemClickListener(listener : (PokemonSpeciesDetail)->Unit){
        onItemClickListener = listener
    }

    class DiffCallback :DiffUtil.ItemCallback<PokemonSpeciesDetail>(){
        override fun areItemsTheSame(oldItem: PokemonSpeciesDetail, newItem: PokemonSpeciesDetail) =
            oldItem.pokemon_species.name == newItem.pokemon_species.name

        override fun areContentsTheSame(oldItem: PokemonSpeciesDetail, newItem: PokemonSpeciesDetail) =
            oldItem == newItem



    }


}