package com.deb.mrcoopertask.presenter.di

import com.deb.mrcoopertask.domain.repository.PokemonRepository
import com.deb.mrcoopertask.domain.usecase.PokemonGenderUseCase
import com.deb.mrcoopertask.domain.usecase.PokemonUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Singleton
    @Provides
    fun provideGetGenderUseCase(
        pokemonRepository: PokemonRepository
    ) : PokemonGenderUseCase {
        return PokemonGenderUseCase(pokemonRepository)
    }

    @Singleton
    @Provides
    fun provideGetPokemonUseCase(
        pokemonRepository: PokemonRepository
    ) : PokemonUseCase {
        return PokemonUseCase(pokemonRepository)
    }
}