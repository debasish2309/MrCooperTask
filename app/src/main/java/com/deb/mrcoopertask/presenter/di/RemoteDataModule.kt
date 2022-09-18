package com.deb.mrcoopertask.presenter.di

import com.deb.mrcoopertask.data.api.PokemonServiceAPI
import com.deb.mrcoopertask.data.repository.datasource.PokemonRemoteDatasource
import com.deb.mrcoopertask.data.repository.datasourceimpl.PokemonRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RemoteDataModule {

    @Provides
    @Singleton
    fun providePokemonRemoteDataSource(
        pokemonServiceAPI: PokemonServiceAPI
    ): PokemonRemoteDatasource {
        return PokemonRemoteDataSourceImpl(pokemonServiceAPI)
    }
}