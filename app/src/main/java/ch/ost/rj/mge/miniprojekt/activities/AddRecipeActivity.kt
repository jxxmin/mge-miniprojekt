package ch.ost.rj.mge.miniprojekt.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import ch.ost.rj.mge.miniprojekt.R
import ch.ost.rj.mge.miniprojekt.model.Recipe
import ch.ost.rj.mge.miniprojekt.model.RecipeRepository
import com.google.android.material.textfield.TextInputEditText

class AddRecipeActivity : AppCompatActivity() {
    private fun saveRecipe() {
        val name = findViewById<TextInputEditText>(R.id.recipe_name_input)
        RecipeRepository.addRecipe(Recipe(name.text.toString()))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_recipe)

        val saveButton = findViewById<Button>(R.id.saveRecipeButton)
        saveButton.setOnClickListener {
            saveRecipe()
            finish()
        }
    }
}
