package com.example.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.data.client.LocationClient
import com.example.data.dto.LocationDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class LocationRepositoryImpl @Inject constructor(
    private val locationClient: LocationClient,
) : LocationRepository {

    override suspend fun loadLocations(): Flow<PagingData<LocationDto>> {
        return Pager(
            config = PagingConfig(enablePlaceholders = false, pageSize = 20),
            pagingSourceFactory = {
                locationClient
            }
        ).flow
    }

    override suspend fun loadLocationById(id: Int): Flow<LocationDto> {
        return flowOf(locationClient.loadById(id))
    }

}