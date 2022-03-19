package com.example.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.data.client.EpisodeClient
import com.example.data.dto.EpisodeDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class EpisodeRepositoryImpl @Inject constructor(
    private val episodeClient: EpisodeClient,
) : EpisodeRepository {

    override suspend fun loadEpisodes(): Flow<PagingData<EpisodeDto>> {
        return Pager(
            config = PagingConfig(enablePlaceholders = false, pageSize = 20),
            pagingSourceFactory = {
                episodeClient
            }
        ).flow
    }

    override suspend fun loadEpisodeById(id: Int): Flow<EpisodeDto> {
        return flowOf(episodeClient.loadById(id))
    }

}