package com.example.domain.usecase.character

import com.example.domain.model.Character
import com.example.domain.repository.CharacterRepository
import dagger.Reusable
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@Reusable
class GetCharacterByIdUseCase @Inject constructor(private val characterRepository: CharacterRepository) {

    suspend fun execute(id: Int): Flow<Character> {
        return characterRepository.loadCharacterById(id)
    }

}