package com.example.game_catalogue.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.game_catalogue.R
import com.example.game_catalogue.databinding.ActivityMainBinding
import com.example.game_catalogue.view.fragment.GameListFragment
import com.example.game_catalogue.view.util.Welcome
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

        val welcome = Welcome(this)

        if (!welcome.isOpened()) {
            navController.navigate(R.id.welcomeFragment)

            welcome.setOpened()
        }

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment,
                R.id.gameListFragment,
                R.id.categoryListFragment,
                R.id.platformListFragment,
                R.id.welcomeFragment
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        bottomNavigationView.setupWithNavController(navController)
        bottomNavigationView.setOnItemSelectedListener { item ->
            if (item.itemId == R.id.gameListFragment) {
                navController.navigate(item.itemId, bundleOf(GameListFragment.ARG_MODE to 0))
            } else {
                navController.navigate(item.itemId)
            }
            true
        }
    }
}