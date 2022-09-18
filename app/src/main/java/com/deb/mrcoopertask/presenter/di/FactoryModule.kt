package com.deb.mrcoopertask.presenter.di

import com.deb.mrcoopertask.domain.usecase.PokemonGenderUseCase
import com.deb.mrcoopertask.domain.usecase.PokemonUseCase
import com.deb.mrcoopertask.presenter.view.PokemonViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {

    @Provides
    @Singleton
    fun providePokemonViewModelFactory(
        pokemonGenderUseCase: PokemonGenderUseCase,
        pokemonUseCase: PokemonUseCase
    ): PokemonViewModelFactory {
        return PokemonViewModelFactory(
            pokemonGenderUseCase,
            pokemonUseCase
        )
    }
}