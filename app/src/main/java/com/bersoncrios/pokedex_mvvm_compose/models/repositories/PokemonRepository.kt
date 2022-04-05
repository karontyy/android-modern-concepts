package com.bersoncrios.pokedex_mvvm_compose.models.repositories

import com.bersoncrios.pokedex_mvvm_compose.models.ConfigureRetrofit
import com.bersoncrios.pokedex_mvvm_compose.models.PokemonResponse

class PokemonRepository(private val webService: ConfigureRetrofit = ConfigureRetrofit()) {
    suspend fun getPokemons(): PokemonResponse {
        return webService.getPokemons()
    }
}