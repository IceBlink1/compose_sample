package com.example.domain.model

data class Episode(
    val id: Int,
    val name: String,
    val airDate: String,
    val episode: String,
    val characterIds: List<String>,
    val url: String,
    val created: String,
)
