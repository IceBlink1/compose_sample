package com.example.data.repository

import androidx.paging.PagingData
import com.example.data.dto.EpisodeDto
import kotlinx.coroutines.flow.Flow

interface EpisodeRepository {

    suspend fun loadEpisodes(): Flow<PagingData<EpisodeDto>>

    suspend fun loadEpisodeById(id: Int): Flow<EpisodeDto>
}