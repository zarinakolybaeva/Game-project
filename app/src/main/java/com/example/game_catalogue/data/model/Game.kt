package com.example.game_catalogue.data.model

data class Game(
    val id: Int,
    val title: String,
    val thumbnail: String,
    val short_description: String,
    val genre: String,
    val release_date: String,
    val freetogame_profile_url: String,
)
