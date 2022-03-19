package com.example.data.repository

import androidx.paging.PagingData
import com.example.data.dto.LocationDto
import kotlinx.coroutines.flow.Flow

interface LocationRepository {

    suspend fun loadLocations(): Flow<PagingData<LocationDto>>

    suspend fun loadLocationById(id: Int): Flow<LocationDto>

}