package com.example.domain.usecase.episode

import com.example.domain.model.Episode
import com.example.domain.repository.EpisodeRepository
import dagger.Reusable
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@Reusable
class GetEpisodeByIdUseCase @Inject constructor(private val episodeRepository: EpisodeRepository) {

    suspend fun execute(id: Int): Flow<Episode> {
        return episodeRepository.loadEpisodeById(id)
    }

}