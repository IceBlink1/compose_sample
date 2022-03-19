package com.example.composeexample.ui.character

import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun CharacterRoute() {
    val characterViewModel: CharacterViewModel = hiltViewModel()
    val state by characterViewModel.stateFlow.collectAsState()
    CharacterRoute(state)
}

@Composable
fun CharacterRoute(
    uiState: CharacterUiState,
    scaffoldState: ScaffoldState = rememberScaffoldState()
) {
    when (uiState) {
        is CharacterUiState.Content -> CharacterScreen(uiState = uiState)
        is CharacterUiState.Loading -> CharacterScreen(uiState = uiState)
    }

}