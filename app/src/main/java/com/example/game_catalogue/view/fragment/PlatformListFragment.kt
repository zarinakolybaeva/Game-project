package com.example.game_catalogue.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.game_catalogue.R
import com.example.game_catalogue.databinding.FragmentPlatformListBinding
import com.example.game_catalogue.view.adapter.PlatformAdapter

class PlatformListFragment : Fragment(R.layout.fragment_platform_list) {
    private lateinit var binding: FragmentPlatformListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentPlatformListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            rvPlatformList.adapter = PlatformAdapter()
            rvPlatformList.layoutManager = LinearLayoutManager(context)
        }
    }
}