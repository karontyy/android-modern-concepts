package com.bersoncrios.pokedex_mvvm_compose.ui.pokemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import com.bersoncrios.pokedex_mvvm_compose.models.Result
import com.bersoncrios.pokedex_mvvm_compose.ui.theme.PokedexmvvmcomposeTheme

@Composable
fun PokemonListScreen() {
    val viewModel: PokemonViewModel = viewModel()
    val pokemons = viewModel.pokemonState.value
    LazyColumn(contentPadding = PaddingValues(16.dp)) {
        items(pokemons) { poke ->
            pokemons(poke)
        }
    }
}

@Composable
fun pokemons(pokemon: Result) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 2.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    ) {
        Row {
            Column(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(16.dp)
            ) {
                Text(
                    text = pokemon.name,
                    style = MaterialTheme.typography.h6
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PokedexmvvmcomposeTheme {
        PokemonListScreen()
    }
}