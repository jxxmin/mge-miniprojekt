package ch.ost.rj.mge.miniprojekt.activities

import android.content.Intent
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
    private fun setDarkMode(darkMode: Boolean) {
        if (darkMode) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            ThemeService.setUsesDarkMode(true)
        }
        else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            ThemeService.setUsesDarkMode(false)
        }
    }

    private fun initDarkMode() {
        val setToDarkMode = ThemeService.getUsesDarkMode()

        if (setToDarkMode && AppCompatDelegate.getDefaultNightMode() != AppCompatDelegate.MODE_NIGHT_YES) {
            setDarkMode(true);
        } else if (!setToDarkMode && AppCompatDelegate.getDefaultNightMode() != AppCompatDelegate.MODE_NIGHT_NO) {
            setDarkMode(false);
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_overview)
        initDarkMode()

        val darkModeButton = findViewById<FloatingActionButton>(R.id.dark_mode_button)
        darkModeButton.setOnClickListener { setDarkMode(!ThemeService.getUsesDarkMode()) }

        val recyclerView = findViewById<RecyclerView>(R.id.recipes_list)
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.adapter = RecipeAdapter()

        val button = findViewById<FloatingActionButton>(R.id.add_recipe_button)
        button.setOnClickListener{
            val intent = Intent(this, AddRecipeActivity::class.java)
            startActivity(intent)
        }
    }
}
