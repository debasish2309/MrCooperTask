package com.deb.mrcoopertask.presenter.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.deb.mrcoopertask.R
import com.deb.mrcoopertask.data.util.Resource
import com.deb.mrcoopertask.databinding.FragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.fragment_detail) {

    private lateinit var binding: FragmentDetailBinding
    private lateinit var viewModel: PokemonViewModel
    private val args: DetailFragmentArgs by navArgs()
    private var isLoading = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailBinding.bind(view)

        viewModel = (activity as MainActivity).viewModel
        viewModel.pokemonDetails.observe(viewLifecycleOwner) { response ->
            when(response) {
                is Resource.Success -> {
                    hideProgressBar()
                    binding.apply {
                        textView.text = response.data?.species?.name.toString()
                        textView2.text = response.data?.weight.toString()
                        textView3.text = response.data?.abilities?.get(0)?.ability?.name.toString()
                    }
                }
                is Resource.Loading -> {
                    showProgressBar()
                }
                is Resource.Error -> {

                }
            }

        }
        viewModel.GetPokemonDetails(args.selectedPokemon)
        binding.apply {
            button.setOnClickListener {
                val action = DetailFragmentDirections.actionDetailFragmentToDetailListFragment("male")
                findNavController().navigate(action)
            }
            button2.setOnClickListener {
                val action = DetailFragmentDirections.actionDetailFragmentToDetailListFragment("female")
                findNavController().navigate(action)
            }
            button3.setOnClickListener {
                val action = DetailFragmentDirections.actionDetailFragmentToDetailListFragment("genderless")
                findNavController().navigate(action)
            }
        }

    }

    private fun showProgressBar(){
        isLoading = true
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar(){
        isLoading = false
        binding.progressBar.visibility = View.INVISIBLE
    }
}