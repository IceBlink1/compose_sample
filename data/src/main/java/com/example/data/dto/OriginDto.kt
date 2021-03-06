package com.example.data.dto

import com.google.gson.annotations.SerializedName


data class OriginDto(
    @SerializedName("name") val name: String? = null,
    @SerializedName("url") val url: String? = null
)