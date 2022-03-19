package com.example.domain.usecase.character

import androidx.paging.PagingData
import androidx.paging.map
import com.example.domain.model.Character
import com.example.data.repository.CharacterRepository
import com.example.domain.mapper.CharacterMapper
import dagger.Reusable
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@Reusable
class GetCharactersUseCase @Inject constructor(
    private val characterRepository: CharacterRepository,
    private val charactersMapper: CharacterMapper
) {

    suspend fun execute(): Flow<PagingData<Character>> {
        return characterRepository.loadCharacters().map { it.map { charactersMapper.map(it) } }
    }

}