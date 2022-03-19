package com.example.composeexample.ui.episode

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun EpisodeRoute() {
    val episodeViewModel: EpisodeViewModel = hiltViewModel()
    val state by episodeViewModel.stateFlow.collectAsState()
    EpisodeRoute(state)
}

@Composable
fun EpisodeRoute(
    uiState: EpisodeUiState
) {
    when (uiState) {
        is EpisodeUiState.Content -> EpisodeScreen(uiState = uiState)
        is EpisodeUiState.Loading -> EpisodeScreen(uiState = uiState)
    }

}