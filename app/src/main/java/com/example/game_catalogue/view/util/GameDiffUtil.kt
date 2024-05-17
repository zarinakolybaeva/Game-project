package com.example.game_catalogue.view.util

import androidx.recyclerview.widget.DiffUtil
import com.example.game_catalogue.data.model.Game

class GameDiffUtil : DiffUtil.ItemCallback<Game>() {
    override fun areItemsTheSame(oldItem: Game, newItem: Game): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Game, newItem: Game): Boolean {
        return oldItem == newItem
    }
}