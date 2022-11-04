package ch.ost.rj.mge.miniprojekt.activities

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ch.ost.rj.mge.miniprojekt.R
import ch.ost.rj.mge.miniprojekt.model.Recipe
import ch.ost.rj.mge.miniprojekt.model.RecipeRepository
import com.google.android.material.textfield.TextInputEditText

class AddRecipeActivity : AppCompatActivity() {
    private lateinit var titleInputText: TextInputEditText
    private lateinit var descriptionInputText: TextInputEditText

    private fun saveRecipe() {
        val name = findViewById<TextInputEditText>(R.id.recipe_name_input)
        val description = findViewById<TextInputEditText>(R.id.recipe_description_input)
        RecipeRepository.addRecipe(Recipe(name.text.toString(), description.text.toString()))
    }


    private fun updateSaveButton() {
        val isValid: (input: TextInputEditText) -> Boolean =
            { input -> input.text.toString().isNotEmpty() }

        val allowSave = isValid(titleInputText) && isValid(descriptionInputText)
        findViewById<Button>(R.id.save_recipe_button).isEnabled = allowSave
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_recipe)

        titleInputText = findViewById(R.id.recipe_name_input)
        titleInputText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun afterTextChanged(editable: Editable) {
                updateSaveButton()
            }
        })

        descriptionInputText = findViewById(R.id.recipe_description_input)
        descriptionInputText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun afterTextChanged(editable: Editable) {
                updateSaveButton()
            }
        })

        val saveButton = findViewById<Button>(R.id.save_recipe_button)
        saveButton.setOnClickListener {
            saveRecipe()
            Toast.makeText(applicationContext, "Rezept wurde gespeichert", Toast.LENGTH_LONG).show()
            finish()
        }
    }
}
