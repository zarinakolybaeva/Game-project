package com.example.game_catalogue.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.game_catalogue.data.model.Game
import com.example.game_catalogue.databinding.ItemGameCardBinding
import com.example.game_catalogue.viewModel.GameViewModel
import androidx.recyclerview.widget.ListAdapter
import com.example.game_catalogue.view.util.GameDiffUtil

class GameAdapter(
    private val gameViewModel: GameViewModel,
    private val onGameItemClicked: (position: Int, games: List<Game>) -> Unit
) : ListAdapter<Game, GameAdapter.GameViewHolder>(GameDiffUtil()) {

    class GameViewHolder(
        private val binding: ItemGameCardBinding,
        private val gameViewModel: GameViewModel,
        private val onGameItemClicked: (position: Int, games: List<Game>) -> Unit
    ) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        private lateinit var games: List<Game>

        init {
            itemView.setOnClickListener(this)
        }

        @SuppressLint("SetTextI18n")
        fun bind(game: Game, games: List<Game>) {
            this.games = games
            binding.apply {
                tvTitle.text = game.title
                tvReleaseDate.text = "Released in: " + game.release_date
                tvShortDescription.text = game.short_description
            }
            Glide.with(binding.root)
                .load(game.thumbnail)
                .into(binding.imgPoster)
        }

        override fun onClick(p0: View?) {
            val position = absoluteAdapterPosition
            onGameItemClicked(position, games)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val binding = ItemGameCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GameViewHolder(binding, gameViewModel, onGameItemClicked)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val game = getItem(position)
        holder.bind(game, currentList)
        holder.itemView.setOnClickListener {
            onGameItemClicked(position, currentList)
        }
    }
}
