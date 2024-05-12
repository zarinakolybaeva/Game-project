package com.example.game_catalogue.view.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.game_catalogue.data.source.remote.GameRemoteRepository
import com.example.game_catalogue.databinding.FragmentGameListBinding
import com.example.game_catalogue.view.adapter.GameAdapter
import com.example.game_catalogue.viewModel.GameViewModel
import android.net.Uri

class GameListFragment : Fragment() {
    private lateinit var binding: FragmentGameListBinding
    private lateinit var gameViewModel: GameViewModel
    private lateinit var rvGamesAdapter: GameAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentGameListBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        gameViewModel = GameViewModel(
            GameRemoteRepository.getInstance()
        )

        when (requireArguments().getInt(ARG_MODE)) {
            0 -> {
                gameViewModel.games.observe(viewLifecycleOwner) { games ->
                    rvGamesAdapter.games = games
                    rvGamesAdapter.notifyDataSetChanged()
                }
                gameViewModel.getAllGames()
            }
            1 -> {
                val category = requireArguments().getString(ARG_CATEGORY)!!
                gameViewModel.games.observe(viewLifecycleOwner) { games ->
                    rvGamesAdapter.games = games
                    rvGamesAdapter.notifyDataSetChanged()
                }
                gameViewModel.getGamesByCategory(category)
            }
            2 -> {
                val platform = requireArguments().getString(ARG_PLATFORM)!!
                gameViewModel.games.observe(viewLifecycleOwner) { games ->
                    rvGamesAdapter.games = games
                    rvGamesAdapter.notifyDataSetChanged()
                }
                gameViewModel.getGamesByPlatform(platform)
            }
        }

        rvGamesAdapter = GameAdapter(gameViewModel) { position, games ->
            val openUrl = Intent(Intent.ACTION_VIEW)
            openUrl.data = Uri.parse(games[position].freetogame_profile_url)
            startActivity(openUrl)
        }
        binding.rvGames.apply {
            adapter = rvGamesAdapter
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
        }
    }

    companion object {
        const val ARG_MODE = "ARG_MODE"
        const val ARG_CATEGORY = "ARG_CATEGORY"
        const val ARG_PLATFORM = "ARG_PLATFORM"
    }
}