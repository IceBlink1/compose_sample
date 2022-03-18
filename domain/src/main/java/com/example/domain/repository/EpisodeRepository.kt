package com.example.domain.repository

import androidx.paging.PagingData
import com.example.domain.model.Episode
import kotlinx.coroutines.flow.Flow

interface EpisodeRepository {

    suspend fun loadEpisodes(): Flow<PagingData<Episode>>

    suspend fun loadEpisodeById(id: Int): Flow<Episode>
}