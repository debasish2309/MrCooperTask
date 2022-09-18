package com.deb.mrcoopertask.presenter.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavArgs
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.deb.mrcoopertask.R
import com.deb.mrcoopertask.data.util.Resource
import com.deb.mrcoopertask.databinding.FragmentListBinding
import com.deb.mrcoopertask.presenter.adapter.PokemonAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment(R.layout.fragment_list) {

    private lateinit var viewModel: PokemonViewModel
    private val gender: String = "female"
    lateinit var binding: FragmentListBinding
    private lateinit var pokemonAdapter: PokemonAdapter
    private var isLoading = false


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentListBinding.bind(view)

        viewModel = (activity as MainActivity).viewModel
        pokemonAdapter = (activity as MainActivity).pokemonAdapter
        binding.apply{
            recyclerview.apply {
                adapter = pokemonAdapter
            }
        }

        pokemonAdapter.setOnItemClickListener {
            val pokemonmane = it.pokemon_species.name
            val action = ListFragmentDirections.actionListFragmentToDetailFragment(pokemonmane)
            findNavController().navigate(action)
        }

        viewModel.pokemonGender.observe(viewLifecycleOwner) { response ->
            when(response) {
                is Resource.Success -> {
                    hideProgressBar()
                    pokemonAdapter.submitList(response.data!!.pokemon_species_details.toList())
                }
                is Resource.Error -> {

                }
                is Resource.Loading -> {
                    showProgressBar()
                }
            }

        }
        viewModel.GetPokemonGender(gender)

        binding.apply {
            button.setOnClickListener { viewModel.GetPokemonGender("male")  }
            button2.setOnClickListener { viewModel.GetPokemonGender("female") }
            button3.setOnClickListener { viewModel.GetPokemonGender("genderless") }
        }
    }

    private fun showProgressBar(){
        isLoading = true
        binding.progressBar3.visibility = View.VISIBLE
    }

    private fun hideProgressBar(){
        isLoading = false
        binding.progressBar3.visibility = View.INVISIBLE
    }
}