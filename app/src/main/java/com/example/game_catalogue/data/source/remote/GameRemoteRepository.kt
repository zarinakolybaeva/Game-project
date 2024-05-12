package com.example.game_catalogue.data.source.remote

import android.util.Log
import com.example.game_catalogue.data.model.Game
import com.example.game_catalogue.data.source.remote.api.ApiClient


class GameRemoteRepository() {
    companion object {
        private var instance: GameRemoteRepository? = null

        fun getInstance() = instance ?: synchronized(this) {
            instance ?: GameRemoteRepository()
        }
    }
    suspend fun getAllGames(): List<Game> {
        return try {
            val apiService = ApiClient.getApiService()
            apiService?.getAllGames() ?: emptyList()
        } catch (e: Exception) {
            Log.e("Error", e.message.toString())
            emptyList()
        }
    }

    suspend fun getGamesByCategoryName(category: String): List<Game> {
        return try {
            val apiService = ApiClient.getApiService()
            apiService?.getGamesByCategory(category) ?: emptyList()
        } catch (e: Exception) {
            Log.e("Error", e.message.toString())
            emptyList()
        }
    }

    suspend fun getGamesByPlatformName(platform: String): List<Game> {
        return try {
            val apiService = ApiClient.getApiService()
            apiService?.getGamesByPlatform(platform) ?: emptyList()
        } catch (e: Exception) {
            Log.e("Error", e.message.toString())
            emptyList()
        }
    }




}