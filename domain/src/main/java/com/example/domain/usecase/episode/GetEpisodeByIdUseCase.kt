package com.example.domain.usecase.episode

import com.example.domain.model.Episode
import com.example.data.repository.EpisodeRepository
import com.example.domain.mapper.EpisodeMapper
import dagger.Reusable
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@Reusable
class GetEpisodeByIdUseCase @Inject constructor(
    private val episodeRepository: EpisodeRepository,
    private val episodeMapper: EpisodeMapper
) {

    suspend fun execute(id: Int): Flow<Episode> {
        return episodeRepository.loadEpisodeById(id).map { episodeMapper.map(it) }
    }

}