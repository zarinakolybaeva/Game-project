package com.example.game_catalogue.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.game_catalogue.data.model.Game
import com.example.game_catalogue.data.source.remote.GameRemoteRepository
import kotlinx.coroutines.launch

class GameViewModel(
    private val gameRepository: GameRemoteRepository,
): ViewModel() {

    private val _games = MutableLiveData<List<Game>>()
    val games: LiveData<List<Game>> get() = _games

    fun getAllGames() {
        viewModelScope.launch {
            try {
                (games as MutableLiveData).value = gameRepository.getAllGames()
            } catch (e: Exception) {
                Log.e("Error", e.message.toString())
            }
        }
    }

    fun getGamesByCategory(category: String) {
        viewModelScope.launch {
            try {
                _games.value = gameRepository.getGamesByCategoryName(category)
            } catch (e: Exception) {
                Log.e("Error", e.message.toString())
            }
        }
    }
}
