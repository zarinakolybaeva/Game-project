package com.example.game_catalogue.data.source.remote.api

import com.example.game_catalogue.data.model.Game
import retrofit2.http.*

interface ApiService {
    @GET("games/")
    suspend fun getAllGames(): List<Game>

    @GET("games/")
    suspend fun getGamesByCategory(
        @Query("category") category: String
    ): List<Game>
}