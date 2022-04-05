package com.bersoncrios.pokedex_mvvm_compose.ui.pokemon

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bersoncrios.pokedex_mvvm_compose.models.Result
import com.bersoncrios.pokedex_mvvm_compose.models.repositories.PokemonRepository
import kotlinx.coroutines.launch

class PokemonViewModel(private val repository: PokemonRepository = PokemonRepository()): ViewModel() {
    init {
        viewModelScope.launch {
            val pokemons = getPokemons()
            pokemonState.value = pokemons
        }
    }

    val pokemonState: MutableState<List<Result>> = mutableStateOf(emptyList<Result>())

    private suspend fun getPokemons(): List<Result> {
        return repository.getPokemons().results
    }
}