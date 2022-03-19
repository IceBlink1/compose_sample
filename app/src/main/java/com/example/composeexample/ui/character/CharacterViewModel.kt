package com.example.composeexample.ui.character

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.example.domain.model.Character
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class CharacterUiState {

    object Loading : CharacterUiState()

    class Content(val pagedData: Flow<PagingData<Character>>) : CharacterUiState()
}

@HiltViewModel
class CharacterViewModel @Inject constructor(private val useCases: CharacterUseCases) :
    ViewModel() {

    private val mutableStateFlow = MutableStateFlow<CharacterUiState>(CharacterUiState.Loading)

    val stateFlow: StateFlow<CharacterUiState> = mutableStateFlow.stateIn(
        viewModelScope,
        SharingStarted.Lazily,
        mutableStateFlow.value
    )

    init {
        loadCharacters()
    }

    fun loadCharacters() {
        viewModelScope.launch {
            mutableStateFlow.emit(CharacterUiState.Content(useCases.getCharacters()))
        }
    }

}