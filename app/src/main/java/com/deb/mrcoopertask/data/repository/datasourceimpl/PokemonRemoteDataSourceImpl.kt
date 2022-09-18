package com.deb.mrcoopertask.data.repository.datasourceimpl

import com.deb.mrcoopertask.data.api.PokemonServiceAPI
import com.deb.mrcoopertask.data.model.ResponseGender.ResponseGender
import com.deb.mrcoopertask.data.model.ResponsePokemon.ResponsePokemon
import com.deb.mrcoopertask.data.repository.datasource.PokemonRemoteDatasource
import retrofit2.Response
import javax.inject.Inject

class PokemonRemoteDataSourceImpl (
    private val pokemonServiceAPI: PokemonServiceAPI
) : PokemonRemoteDatasource {
    override suspend fun GetPokemonGender(Gender: String): Response<ResponseGender> {
        return pokemonServiceAPI.GetGender(Gender)
    }

    override suspend fun GetPokemonDetail(Name: String): Response<ResponsePokemon> {
        return pokemonServiceAPI.GetPokemon(Name)
    }
}