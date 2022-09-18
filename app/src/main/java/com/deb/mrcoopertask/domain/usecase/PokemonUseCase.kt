package com.deb.mrcoopertask.domain.usecase

import com.deb.mrcoopertask.data.model.ResponsePokemon.ResponsePokemon
import com.deb.mrcoopertask.data.util.Resource
import com.deb.mrcoopertask.domain.repository.PokemonRepository

class PokemonUseCase(private val pokemonRepository: PokemonRepository) {

    suspend fun execute(Name: String): Resource<ResponsePokemon> {
        return pokemonRepository.GetPokemon(Name)
    }
}