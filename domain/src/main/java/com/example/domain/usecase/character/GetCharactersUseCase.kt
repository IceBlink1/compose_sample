package com.example.domain.usecase.character

import androidx.paging.PagingData
import com.example.domain.model.Character
import com.example.domain.repository.CharacterRepository
import dagger.Reusable
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@Reusable
class GetCharactersUseCase @Inject constructor(private val characterRepository: CharacterRepository) {

    suspend fun execute(): Flow<PagingData<Character>> {
        return characterRepository.loadCharacters()
    }

}