package com.deb.mrcoopertask.presenter.di


import com.deb.mrcoopertask.BuildConfig
import com.deb.mrcoopertask.data.api.PokemonServiceAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideNetworkService(retrofit: Retrofit):PokemonServiceAPI{
        return retrofit.create(PokemonServiceAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_KEY)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


}