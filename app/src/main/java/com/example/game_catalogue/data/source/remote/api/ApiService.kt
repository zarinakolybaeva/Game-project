package com.example.game_catalogue.data.source.remote.api

import com.example.game_catalogue.data.model.Game
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("game/")
    fun getAllGames(): Call<List<Game>>

    @GET("games/")
    fun getGamesByCategory(
        @Query("category") category: String
    ): Call<List<Game>>
}