package com.deb.mrcoopertask.data.api

import com.deb.mrcoopertask.data.model.ResponseGender.ResponseGender
import com.deb.mrcoopertask.data.model.ResponsePokemon.ResponsePokemon
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface PokemonServiceAPI {

    @GET("v2/gender/{gender}")
    suspend fun GetGender(@Path("gender") gender: String): Response<ResponseGender>

    @GET("v2/pokemon/{name}")
    suspend fun GetPokemon(@Path("name") name: String): Response<ResponsePokemon>
}