package com.example.domain.usecase.character

import com.example.domain.model.Character
import com.example.data.repository.CharacterRepository
import com.example.domain.mapper.CharacterMapper
import dagger.Reusable
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@Reusable
class GetCharacterByIdUseCase @Inject constructor(
    private val characterRepository: CharacterRepository,
    private val charactersMapper: CharacterMapper
) {

    suspend fun execute(id: Int): Flow<Character> {
        return characterRepository.loadCharacterById(id).map { charactersMapper.map(it) }
    }

}