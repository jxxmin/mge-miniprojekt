package ch.ost.rj.mge.miniprojekt.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ch.ost.rj.mge.miniprojekt.R
import ch.ost.rj.mge.miniprojekt.adapter.RecipeAdapter
import ch.ost.rj.mge.miniprojekt.services.ThemeService
import com.google.android.material.floatingactionbutton.FloatingActionButton

class OverviewActivity : AppCompatActivity() {
    private fun toggleDarkMode() {
        if (ThemeService.getUsesDarkMode()) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            ThemeService.setUsesDarkMode(false)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            ThemeService.setUsesDarkMode(true)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO get uses dark mode from preferences but only on first loading!
        setContentView(R.layout.activity_overview)

        val darkModeButton = findViewById<FloatingActionButton>(R.id.dark_mode_button)
        darkModeButton.setOnClickListener { toggleDarkMode() }

        val recyclerView = findViewById<RecyclerView>(R.id.recipes_list)
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.adapter = RecipeAdapter()
    }
}
