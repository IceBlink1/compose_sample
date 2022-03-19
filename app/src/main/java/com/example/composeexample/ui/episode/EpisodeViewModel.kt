package com.example.composeexample.ui.episode

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.example.domain.model.Episode
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class EpisodeUiState {

    object Loading : EpisodeUiState()

    class Content(val pagedData: Flow<PagingData<Episode>>) : EpisodeUiState()
}

@HiltViewModel
class EpisodeViewModel @Inject constructor(private val useCases: EpisodeUseCases) :
    ViewModel() {

    private val mutableStateFlow = MutableStateFlow<EpisodeUiState>(EpisodeUiState.Loading)

    val stateFlow: StateFlow<EpisodeUiState> = mutableStateFlow.stateIn(
        viewModelScope,
        SharingStarted.Lazily,
        mutableStateFlow.value
    )

    init {
        loadEpisodes()
    }

    fun loadEpisodes() {
        viewModelScope.launch {
            mutableStateFlow.emit(EpisodeUiState.Content(useCases.getEpisodes()))
        }
    }

}