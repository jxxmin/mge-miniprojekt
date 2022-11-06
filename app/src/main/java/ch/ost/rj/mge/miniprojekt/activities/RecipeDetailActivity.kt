package ch.ost.rj.mge.miniprojekt.activities

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import ch.ost.rj.mge.miniprojekt.R
import ch.ost.rj.mge.miniprojekt.model.RecipeRepository

class RecipeDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_detail)

        val id = this.intent.getIntExtra("ID", -1)
        val recipe = RecipeRepository.getRecipeById(id)

        title = recipe.name

        findViewById<TextView>(R.id.recipe_detail_description).text = recipe.description
        findViewById<ImageView>(R.id.full_image).setImageURI(Uri.parse(recipe.image))
    }
}
