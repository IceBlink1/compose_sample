package com.example.data.dto

import com.google.gson.annotations.SerializedName

data class EpisodeListDto(
    @SerializedName("info") val pageInfo: PageInfo? = PageInfo(),
    @SerializedName("results") val results: ArrayList<EpisodeDto> = arrayListOf(),
)