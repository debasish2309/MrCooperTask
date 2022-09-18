package com.deb.mrcoopertask.presenter.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.deb.mrcoopertask.data.model.ResponseGender.ResponseGender
import com.deb.mrcoopertask.data.model.ResponsePokemon.ResponsePokemon
import com.deb.mrcoopertask.domain.usecase.PokemonGenderUseCase
import com.deb.mrcoopertask.data.util.Resource
import com.deb.mrcoopertask.domain.usecase.PokemonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(
    private val pokemonGenderUseCase: PokemonGenderUseCase,
    private val pokemonUseCase: PokemonUseCase
    ) : ViewModel() {

    val pokemonGender: MutableLiveData<Resource<ResponseGender>> = MutableLiveData()

    fun GetPokemonGender(Gender : String) = viewModelScope.launch(Dispatchers.IO) {
        try {
            pokemonGender.postValue(Resource.Loading())

            val apiResult = pokemonGenderUseCase.execute(Gender)
            pokemonGender.postValue(apiResult)
        } catch (ex: Exception){
            pokemonGender.postValue(Resource.Error(ex.message.toString()))
        }
    }

    val pokemonDetails: MutableLiveData<Resource<ResponsePokemon>> = MutableLiveData()

    fun GetPokemonDetails(Name: String) = viewModelScope.launch(Dispatchers.IO) {
        try {
            pokemonDetails.postValue(Resource.Loading())

            val apiResult = pokemonUseCase.execute(Name)
            pokemonDetails.postValue(apiResult)
        } catch (ex: Exception){
            pokemonDetails.postValue(Resource.Error(ex.message.toString()))
        }
    }

}