package com.example.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.example.data.client.EpisodeClient
import com.example.data.mapper.EpisodeMapper
import com.example.domain.model.Character
import com.example.domain.model.Episode
import com.example.domain.repository.EpisodeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class EpisodeRepositoryImpl @Inject constructor(
    private val episodeClient: EpisodeClient,
    private val episodeMapper: EpisodeMapper,
) : EpisodeRepository {

    override suspend fun loadEpisodes(): Flow<PagingData<Episode>> {
        return Pager(
            config = PagingConfig(enablePlaceholders = false, pageSize = 20),
            pagingSourceFactory = {
                episodeClient
            }
        ).flow.map {
            it.map {
                episodeMapper.map(it)
            }
        }
    }

    override suspend fun loadEpisodeById(id: Int): Flow<Episode> {
        return flowOf(episodeClient.loadById(id)).map { episodeMapper.map(it) }
    }

}