package com.example.data.dto

import com.google.gson.annotations.SerializedName

data class CharacterListDto(
    @SerializedName("info") val pageInfo: PageInfo? = PageInfo(),
    @SerializedName("results") val results: ArrayList<CharacterDto> = arrayListOf(),
)