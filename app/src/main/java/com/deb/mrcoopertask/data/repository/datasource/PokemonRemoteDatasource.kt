package com.deb.mrcoopertask.data.repository.datasource

import com.deb.mrcoopertask.data.model.ResponseGender.ResponseGender
import com.deb.mrcoopertask.data.model.ResponsePokemon.ResponsePokemon
import retrofit2.Response

interface PokemonRemoteDatasource {

    suspend fun GetPokemonGender(Gender: String): Response<ResponseGender>

    suspend fun GetPokemonDetail(Name: String) : Response<ResponsePokemon>
}