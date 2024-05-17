package com.example.game_catalogue.view.util

import android.content.Context

class Welcome(context: Context) {

    private val sharedPreferences = context.getSharedPreferences("NewOrNot", Context.MODE_PRIVATE)

    fun setOpened() {
        sharedPreferences.edit().putBoolean("AlreadyOpened", true).apply()
    }

    fun isOpened(): Boolean {
        return sharedPreferences.getBoolean("AlreadyOpened", false)
    }
}