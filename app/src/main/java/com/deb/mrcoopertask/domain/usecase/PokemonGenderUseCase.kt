package com.deb.mrcoopertask.domain.usecase

import com.deb.mrcoopertask.data.model.ResponseGender.ResponseGender
import com.deb.mrcoopertask.data.util.Resource
import com.deb.mrcoopertask.domain.repository.PokemonRepository
import javax.inject.Inject

class PokemonGenderUseCase (private val pokemonRepository: PokemonRepository) {
    suspend fun execute(Gender : String):Resource<ResponseGender> {
        return pokemonRepository.GetFemaleList(Gender)
    }
}