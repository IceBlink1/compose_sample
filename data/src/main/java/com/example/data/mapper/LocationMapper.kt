package com.example.data.mapper

import com.example.data.dto.LocationDto
import com.example.domain.model.Location

class LocationMapper {

    fun map(locationDto: LocationDto): Location {
        return Location(
            id = locationDto.id!!,
            name = locationDto.name!!,
            type = locationDto.type!!,
            dimension = locationDto.dimension!!,
            residentIds = locationDto.residents.map { it[it.length - 1].toString() },
            url = locationDto.url!!,
            created = locationDto.created!!,
        )
    }

}