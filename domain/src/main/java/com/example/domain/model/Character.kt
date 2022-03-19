package com.example.domain.model

data class Character(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val originId: Int,
    val locationId: Int,
    val image: String? = null,
    val episode: ArrayList<String> = arrayListOf(),
    val url: String,
    val created: String,
    val locationName: String,
    val originName: String,
)