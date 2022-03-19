package com.example.domain.usecase.location

import androidx.paging.PagingData
import androidx.paging.map
import com.example.domain.model.Location
import com.example.data.repository.LocationRepository
import com.example.domain.mapper.LocationMapper
import dagger.Reusable
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


@Reusable
class GetLocationsUseCase @Inject constructor(
    private val locationRepository: LocationRepository,
    private val locationMapper: LocationMapper
) {

    suspend fun execute(): Flow<PagingData<Location>> {
        return locationRepository.loadLocations().map { it.map { locationMapper.map(it) } }
    }

}