package com.bersoncrios.pokedex_mvvm_compose.models

import retrofit2.http.GET

interface Api {
    @GET("pokemon/")
    suspend fun getPokemons(): PokemonResponse
}