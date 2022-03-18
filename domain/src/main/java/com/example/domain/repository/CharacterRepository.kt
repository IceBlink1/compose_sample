package com.example.domain.repository

import androidx.paging.PagingData
import com.example.domain.model.Character
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {

    suspend fun loadCharacters(): Flow<PagingData<Character>>

    suspend fun loadCharacterById(id: Int): Flow<Character>

}