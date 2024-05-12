package com.example.game_catalogue.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.game_catalogue.R
import com.example.game_catalogue.databinding.PlatformItemBinding
import com.example.game_catalogue.view.fragment.GameListFragment

class PlatformAdapter(): RecyclerView.Adapter<PlatformAdapter.PlatformViewHolder>() {
    private val platforms = listOf("pc", "browser", "all")

    class PlatformViewHolder(
        private val binding: PlatformItemBinding,
        val navController: NavController):
        RecyclerView.ViewHolder(binding.root){
        fun bind(platform: String) {
            binding.tvPlatformTitle.text = platform
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlatformViewHolder {
        val binding = PlatformItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val navController = parent.findNavController()
        return PlatformViewHolder(binding, navController)
    }

    override fun onBindViewHolder(holder: PlatformViewHolder, position: Int) {
        val platform = platforms[position]
        holder.bind(platform)
        holder.itemView.setOnClickListener {
            holder.navController.navigate(
                R.id.action_platformListFragment_to_gameListFragment,
                bundleOf(GameListFragment.ARG_MODE to 2, GameListFragment.ARG_PLATFORM to platform)
            )
        }
    }

    override fun getItemCount() = platforms.size
}