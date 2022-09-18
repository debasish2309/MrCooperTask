package com.deb.mrcoopertask.data.model.ResponseGender

data class ResponseGender(
    val id: Int,
    val name: String,
    val pokemon_species_details: List<PokemonSpeciesDetail>,
    val required_for_evolution: List<RequiredForEvolution>
)



data class PokemonSpeciesDetail(
    val pokemon_species: PokemonSpecies,
    val rate: Int
)

data class RequiredForEvolution(
    val name: String,
    val url: String
)

data class PokemonSpecies(
    val name: String,
    val url: String
)