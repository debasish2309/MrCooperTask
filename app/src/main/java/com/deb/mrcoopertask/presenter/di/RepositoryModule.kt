package com.deb.mrcoopertask.presenter.di

import com.deb.mrcoopertask.data.repository.PokemonRepositoryImpl
import com.deb.mrcoopertask.data.repository.datasource.PokemonRemoteDatasource
import com.deb.mrcoopertask.domain.repository.PokemonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun providePokemonRepository(
        pokemonRemoteDatasource: PokemonRemoteDatasource
    ) : PokemonRepository {
        return PokemonRepositoryImpl(
            pokemonRemoteDatasource
        )
    }
}