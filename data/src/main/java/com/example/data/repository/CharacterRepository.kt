package com.example.data.repository

import androidx.paging.PagingData
import com.example.data.dto.CharacterDto
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {

    suspend fun loadCharacters(): Flow<PagingData<CharacterDto>>

    suspend fun loadCharacterById(id: Int): Flow<CharacterDto>

}