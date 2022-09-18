package com.deb.mrcoopertask.domain.repository

import com.deb.mrcoopertask.data.model.ResponseGender.ResponseGender
import com.deb.mrcoopertask.data.model.ResponsePokemon.ResponsePokemon
import com.deb.mrcoopertask.data.util.Resource

interface PokemonRepository {

    suspend fun GetFemaleList(Gender : String): Resource<ResponseGender>

    suspend fun GetPokemon(name: String) : Resource<ResponsePokemon>
}