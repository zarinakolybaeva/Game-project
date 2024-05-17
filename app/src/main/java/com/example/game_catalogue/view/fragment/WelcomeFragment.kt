package com.example.game_catalogue.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.game_catalogue.R
import com.example.game_catalogue.databinding.FragmentWelcomeBinding
import com.example.game_catalogue.view.util.Welcome
class WelcomeFragment : Fragment() {
    private lateinit var binding: FragmentWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnEnter.setOnClickListener {
            Welcome(requireContext()).setOpened()

            val navOptions = NavOptions.Builder()
                .setPopUpTo(R.id.welcomeFragment, true)
                .build()
            findNavController().navigate(R.id.action_welcome_fragment_to_home_fragment, null, navOptions)
        }
    }
}