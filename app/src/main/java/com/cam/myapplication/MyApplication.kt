package com.cam.myapplication

import android.app.Activity
import android.app.Application
import androidx.appcompat.app.AppCompatDelegate

class MyApplication : Application() {

    var launchCount = 0
        private set

    override fun onCreate() {
        super.onCreate()
        loadLaunchCount()
        incrementLaunchCount()
    }

    private fun loadLaunchCount() {
        val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
        launchCount = sharedPreferences.getInt("launchCount", 0)
    }

    private fun incrementLaunchCount() {
        launchCount++
        val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putInt("launchCount", launchCount)
        editor.apply()
    }

    fun toggleDarkMode(activity: Activity, darkMode: Boolean) {
        val mode = if (darkMode) {
            AppCompatDelegate.MODE_NIGHT_YES
        } else {
            AppCompatDelegate.MODE_NIGHT_NO
        }
        AppCompatDelegate.setDefaultNightMode(mode)

        activity.recreate()
    }

}


