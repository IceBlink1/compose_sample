package com.example.composeexample.ui.episode

import androidx.paging.PagingData
import com.example.domain.model.Episode
import com.example.domain.usecase.episode.GetEpisodesUseCase
import dagger.Lazy
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class EpisodeUseCases @Inject constructor(private val getEpisodesUseCase: Lazy<GetEpisodesUseCase>) {

    suspend fun getEpisodes(): Flow<PagingData<Episode>> {
        return getEpisodesUseCase.get().execute()
    }

}