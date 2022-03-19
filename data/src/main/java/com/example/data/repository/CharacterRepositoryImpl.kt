package com.example.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.data.client.CharacterClient
import com.example.data.dto.CharacterDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val characterClient: CharacterClient,
) : CharacterRepository {
    override suspend fun loadCharacters(): Flow<PagingData<CharacterDto>> {
        return Pager(
            config = PagingConfig(enablePlaceholders = false, pageSize = 20),
            pagingSourceFactory = {
                characterClient
            }
        ).flow
    }

    override suspend fun loadCharacterById(id: Int): Flow<CharacterDto> {
        return flowOf(characterClient.loadById(id))
    }


}