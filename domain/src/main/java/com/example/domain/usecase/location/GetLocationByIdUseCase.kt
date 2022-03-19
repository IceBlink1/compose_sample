package com.example.domain.usecase.location

import androidx.paging.PagingData
import com.example.domain.model.Location
import com.example.data.repository.LocationRepository
import com.example.domain.mapper.LocationMapper
import dagger.Reusable
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


@Reusable
class GetLocationByIdUseCase @Inject constructor(
    private val locationRepository: LocationRepository,
    private val locationMapper: LocationMapper
) {

    suspend fun execute(id: Int): Flow<Location> {
        return locationRepository.loadLocationById(id).map { locationMapper.map(it) }
    }

}