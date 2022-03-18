package com.example.data.mapper

import com.example.data.dto.EpisodeDto
import com.example.domain.model.Episode

class EpisodeMapper {

    fun map(episodeDto: EpisodeDto): Episode {
        return Episode(
            id = episodeDto.id!!,
            url = episodeDto.url!!,
            name = episodeDto.name!!,
            airDate = episodeDto.airDate!!,
            episode = episodeDto.episode!!,
            characterIds = episodeDto.characters.map { it[it.length - 1].toString() },
            created = episodeDto.created!!,
        )
    }

}