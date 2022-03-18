package com.example.data.mapper

import com.example.data.dto.CharacterDto
import com.example.domain.model.Character
import javax.inject.Inject

class CharacterMapper @Inject constructor() {

    fun map(characterDto: CharacterDto): Character {
        return Character(
            id = characterDto.id!!,
            name = characterDto.name!!,
            status = characterDto.status!!,
            species = characterDto.species!!,
            type = characterDto.type!!,
            gender = characterDto.gender!!,
            originId = characterDto.originDto?.url!![characterDto.originDto?.url?.length!! - 1].digitToInt(),
            locationId = characterDto.locationDto?.url!![characterDto.originDto?.url?.length!! - 1].digitToInt(),
            image = characterDto.image,
            episode = characterDto.episode,
            url = characterDto.url!!,
            created = characterDto.created!!,
        )
    }

}