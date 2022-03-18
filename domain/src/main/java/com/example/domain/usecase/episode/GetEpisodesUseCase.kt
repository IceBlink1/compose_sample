package com.example.domain.usecase.episode

import androidx.paging.PagingData
import com.example.domain.model.Episode
import com.example.domain.repository.EpisodeRepository
import dagger.Reusable
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


@Reusable
class GetEpisodesUseCase @Inject constructor(private val episodeRepository: EpisodeRepository) {

    suspend fun execute(): Flow<PagingData<Episode>> {
        return episodeRepository.loadEpisodes()
    }

}