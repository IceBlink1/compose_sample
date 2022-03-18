package com.example.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.example.data.client.LocationClient
import com.example.data.mapper.LocationMapper
import com.example.domain.model.Episode
import com.example.domain.model.Location
import com.example.domain.repository.LocationRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocationRepositoryImpl @Inject constructor(
    private val locationClient: LocationClient,
    private val locationMapper: LocationMapper,
) : LocationRepository {

    override suspend fun loadLocations(): Flow<PagingData<Location>> {
        return Pager(
            config = PagingConfig(enablePlaceholders = false, pageSize = 20),
            pagingSourceFactory = {
                locationClient
            }
        ).flow.map {
            it.map {
                locationMapper.map(it)
            }
        }
    }

    override suspend fun loadLocationById(id: Int): Flow<Location> {
        return flowOf(locationClient.loadById(id)).map { locationMapper.map(it) }
    }

}