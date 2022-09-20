package com.deb.mrcoopertask.presenter.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.deb.mrcoopertask.domain.usecase.PokemonGenderUseCase
import com.deb.mrcoopertask.domain.usecase.PokemonUseCase
import javax.inject.Inject

class PokemonViewModelFactory @Inject constructor(
    private val pokemonGenderUseCase : PokemonGenderUseCase,
    private val pokemonUseCase: PokemonUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PokemonViewModel(
            pokemonGenderUseCase,
            pokemonUseCase
        ) as T
    }
}