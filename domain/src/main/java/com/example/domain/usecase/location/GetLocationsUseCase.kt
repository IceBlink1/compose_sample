package com.example.domain.usecase.location

import androidx.paging.PagingData
import com.example.domain.model.Location
import com.example.domain.repository.LocationRepository
import dagger.Reusable
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


@Reusable
class GetLocationsUseCase @Inject constructor(private val locationRepository: LocationRepository) {

    suspend fun execute(): Flow<PagingData<Location>> {
        return locationRepository.loadLocations()
    }

}