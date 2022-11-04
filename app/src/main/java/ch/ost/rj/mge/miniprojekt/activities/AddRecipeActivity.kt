package ch.ost.rj.mge.miniprojekt.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import ch.ost.rj.mge.miniprojekt.R
import ch.ost.rj.mge.miniprojekt.model.Recipe
import ch.ost.rj.mge.miniprojekt.model.RecipeRepository
import com.google.android.material.textfield.TextInputEditText

class AddRecipeActivity : AppCompatActivity() {
    private fun saveRecipe() {
        val name = findViewById<TextInputEditText>(R.id.recipe_name_input)
        val description = findViewById<TextInputEditText>(R.id.recipe_description_input)
        RecipeRepository.addRecipe(Recipe(name.text.toString(), description.text.toString()))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_recipe)

        val saveButton = findViewById<Button>(R.id.saveRecipeButton)
        saveButton.setOnClickListener {
            saveRecipe()
            Toast.makeText(applicationContext, "Rezept wurde gespeichert", Toast.LENGTH_LONG).show()
            finish()
        }
    }
}
