package com.bersoncrios.pokedex_mvvm_compose.models

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ConfigureRetrofit {

    private lateinit var api: Api

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(Api::class.java)
    }

    suspend fun getPokemons(): PokemonResponse {
        return  api.getPokemons()
    }
}