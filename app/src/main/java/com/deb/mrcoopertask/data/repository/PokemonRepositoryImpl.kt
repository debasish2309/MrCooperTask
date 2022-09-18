package com.deb.mrcoopertask.data.repository

import com.deb.mrcoopertask.data.model.ResponseGender.ResponseGender
import com.deb.mrcoopertask.data.model.ResponsePokemon.ResponsePokemon
import com.deb.mrcoopertask.data.repository.datasource.PokemonRemoteDatasource
import com.deb.mrcoopertask.domain.repository.PokemonRepository
import com.deb.mrcoopertask.data.util.Resource
import retrofit2.Response
import javax.inject.Inject

class PokemonRepositoryImpl (
    private val pokemonRemoteDatasource: PokemonRemoteDatasource
) : PokemonRepository {
    override suspend fun GetFemaleList(Gender : String): Resource<ResponseGender> {
         return responseToResource(pokemonRemoteDatasource.GetPokemonGender(Gender))
    }

    override suspend fun GetPokemon(Name: String): Resource<ResponsePokemon> {
        return responseToResourcePokemon(pokemonRemoteDatasource.GetPokemonDetail(Name))
    }

    private fun responseToResource(response: Response<ResponseGender>) : Resource<ResponseGender> {
        if(response.isSuccessful){
            response.body()?.let { result ->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }

    private fun responseToResourcePokemon(response: Response<ResponsePokemon>) : Resource<ResponsePokemon> {
        if(response.isSuccessful){
            response.body()?.let { result ->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }
}