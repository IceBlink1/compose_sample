package com.example.domain.model

data class Location(
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
    val residentIds: List<String> = arrayListOf(),
    val url: String,
    val created: String
)