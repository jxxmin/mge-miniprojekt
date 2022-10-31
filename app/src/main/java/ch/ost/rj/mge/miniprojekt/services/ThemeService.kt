package ch.ost.rj.mge.miniprojekt.services

import android.content.Context
import android.content.SharedPreferences

object ThemeService {
    lateinit var preferences: SharedPreferences
    private const val fileName = "ch.ost.rj.mge.miniprojekt.preferences"

    fun initialize(context: Context) {
        preferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE)
    }

    fun getUsesDarkMode(): Boolean {
        return preferences.getBoolean("darkMode", false)
    }

    fun setUsesDarkMode(darkMode: Boolean) {
        preferences.edit().putBoolean("darkMode", darkMode).apply()
    }
}
