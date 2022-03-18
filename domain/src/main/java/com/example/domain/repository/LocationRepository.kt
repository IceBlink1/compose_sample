package com.example.domain.repository

import androidx.paging.PagingData
import com.example.domain.model.Location
import kotlinx.coroutines.flow.Flow

interface LocationRepository {

    suspend fun loadLocations(): Flow<PagingData<Location>>

    suspend fun loadLocationById(id: Int): Flow<Location>

}