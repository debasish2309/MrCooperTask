package com.deb.mrcoopertask.presenter.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.deb.mrcoopertask.R
import com.deb.mrcoopertask.data.util.Resource
import com.deb.mrcoopertask.databinding.FragmentDetailListBinding
import com.deb.mrcoopertask.presenter.adapter.PokemonAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailListFragment : Fragment(R.layout.fragment_detail_list) {

    lateinit var binding: FragmentDetailListBinding
    private lateinit var viewModel: PokemonViewModel
    private val args: DetailListFragmentArgs by navArgs()
    private lateinit var pokemonAdapter: PokemonAdapter
    private var isLoading = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailListBinding.bind(view)

        viewModel = (activity as MainActivity).viewModel
        pokemonAdapter = (activity as MainActivity).pokemonAdapter
        binding.apply{
            recyclerview.apply {
                adapter = pokemonAdapter
            }
        }

        pokemonAdapter.setOnItemClickListener {
            Toast.makeText(activity,"Sorry cannot proceed",Toast.LENGTH_SHORT).show()
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

        viewModel.GetPokemonGender(args.selectedFilter)
    }

    private fun showProgressBar(){
        isLoading = true
        binding.progressBar2.visibility = View.VISIBLE
    }

    private fun hideProgressBar(){
        isLoading = false
        binding.progressBar2.visibility = View.INVISIBLE
    }
}