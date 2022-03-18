package com.example.data.dto

import com.google.gson.annotations.SerializedName

data class CharacterDto(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("status") val status: String? = null,
    @SerializedName("species") val species: String? = null,
    @SerializedName("type") val type: String? = null,
    @SerializedName("gender") val gender: String? = null,
    @SerializedName("origin") val originDto: OriginDto? = OriginDto(),
    @SerializedName("location") val locationDto: LocationDto? = LocationDto(),
    @SerializedName("image") val image: String? = null,
    @SerializedName("episode") val episode: ArrayList<String> = arrayListOf(),
    @SerializedName("url") val url: String? = null,
    @SerializedName("created") val created: String? = null,
)