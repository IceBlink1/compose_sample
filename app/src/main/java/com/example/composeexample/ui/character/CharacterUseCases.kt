package com.example.composeexample.ui.character

import androidx.paging.PagingData
import com.example.domain.model.Character
import com.example.domain.usecase.character.GetCharactersUseCase
import dagger.Lazy
import dagger.Reusable
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@Reusable
class CharacterUseCases @Inject constructor(
    private val getCharactersUseCase: Lazy<GetCharactersUseCase>
) {

    suspend fun getCharacters(): Flow<PagingData<Character>> {
        return getCharactersUseCase.get().execute()
    }

}