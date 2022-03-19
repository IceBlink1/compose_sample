package com.example.composeexample.ui.location

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun LocationRoute() {
    val LocationViewModel: LocationViewModel = hiltViewModel()
    val state by LocationViewModel.stateFlow.collectAsState()
    LocationRoute(state)
}

@Composable
fun LocationRoute(
    uiState: LocationUiState
) {
    when (uiState) {
        is LocationUiState.Content -> LocationScreen(uiState = uiState)
        is LocationUiState.Loading -> LocationScreen(uiState = uiState)
    }

}