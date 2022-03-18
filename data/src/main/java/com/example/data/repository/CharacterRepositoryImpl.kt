package com.example.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.example.data.client.CharacterClient
import com.example.data.mapper.CharacterMapper
import com.example.domain.model.Character
import com.example.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val characterClient: CharacterClient,
    private val characterMapper: CharacterMapper,
) : CharacterRepository {
    override suspend fun loadCharacters(): Flow<PagingData<Character>> {
        return Pager(
            config = PagingConfig(enablePlaceholders = false, pageSize = 20),
            pagingSourceFactory = {
                characterClient
            }
        ).flow.map {
            it.map {
                characterMapper.map(it)
            }
        }
    }

    override suspend fun loadCharacterById(id: Int): Flow<Character> {
        return flowOf(characterClient.loadById(id)).map { characterMapper.map(it) }
    }


}