package com.example.domain.usecase.episode

import androidx.paging.PagingData
import androidx.paging.map
import com.example.domain.model.Episode
import com.example.data.repository.EpisodeRepository
import com.example.domain.mapper.EpisodeMapper
import dagger.Reusable
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


@Reusable
class GetEpisodesUseCase @Inject constructor(
    private val episodeRepository: EpisodeRepository,
    private val episodeMapper: EpisodeMapper
) {

    suspend fun execute(): Flow<PagingData<Episode>> {
        return episodeRepository.loadEpisodes().map { it.map { episodeMapper.map(it) } }
    }

}