package com.example.composeexample.ui.location

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.example.composeexample.ui.Location.LocationUseCases
import com.example.domain.model.Location
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class LocationUiState {

    object Loading : LocationUiState()

    class Content(val pagedData: Flow<PagingData<Location>>) : LocationUiState()
}

@HiltViewModel
class LocationViewModel @Inject constructor(private val useCases: LocationUseCases) :
    ViewModel() {

    private val mutableStateFlow = MutableStateFlow<LocationUiState>(LocationUiState.Loading)

    val stateFlow: StateFlow<LocationUiState> = mutableStateFlow.stateIn(
        viewModelScope,
        SharingStarted.Lazily,
        mutableStateFlow.value
    )

    init {
        loadLocations()
    }

    fun loadLocations() {
        viewModelScope.launch {
            mutableStateFlow.emit(LocationUiState.Content(useCases.getLocations()))
        }
    }

}