package com.example.composeexample.ui.Location

import androidx.paging.PagingData
import com.example.domain.model.Location
import com.example.domain.usecase.location.GetLocationsUseCase
import dagger.Lazy
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocationUseCases @Inject constructor(private val getLocationsUseCase: Lazy<GetLocationsUseCase>) {

    suspend fun getLocations(): Flow<PagingData<Location>> {
        return getLocationsUseCase.get().execute()
    }

}