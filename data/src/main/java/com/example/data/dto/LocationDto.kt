package com.example.data.dto

import com.google.gson.annotations.SerializedName

data class LocationDto(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("type") val type: String? = null,
    @SerializedName("dimension") val dimension: String? = null,
    @SerializedName("residents") val residents: ArrayList<String> = arrayListOf(),
    @SerializedName("url") val url: String? = null,
    @SerializedName("created") val created: String? = null
)