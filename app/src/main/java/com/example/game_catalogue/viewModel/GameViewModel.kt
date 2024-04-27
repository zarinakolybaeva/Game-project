package com.example.game_catalogue.viewModel

import androidx.lifecycle.ViewModel
import com.example.game_catalogue.data.source.remote.GameRemoteRepository

class GameViewModel(
    private val gameRepository: GameRemoteRepository,
): ViewModel() {
    fun getAllGames() = gameRepository.getAllGames()

    fun getGamesByCategory(category: String) = gameRepository.getGamesByCategoryName(category)

}