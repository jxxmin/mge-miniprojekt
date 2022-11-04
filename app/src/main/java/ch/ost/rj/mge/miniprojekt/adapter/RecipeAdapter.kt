package ch.ost.rj.mge.miniprojekt.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import ch.ost.rj.mge.miniprojekt.R
import ch.ost.rj.mge.miniprojekt.activities.AddRecipeActivity
import ch.ost.rj.mge.miniprojekt.activities.RecipeDetailActivity
import ch.ost.rj.mge.miniprojekt.model.Recipe
import ch.ost.rj.mge.miniprojekt.model.RecipeRepository

class RecipeAdapter() :
    RecyclerView.Adapter<RecipeViewHolder>() {
    private var recipes: List<Recipe> = ArrayList<Recipe>(RecipeRepository.getRecipes())
    private lateinit var context: Context;

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        context = parent.context;
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_overview_layout, parent, false)

        return RecipeViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = this.recipes[position]
        holder.name.text = recipe.name

        holder.name.setOnClickListener {
            val intent = Intent(context, RecipeDetailActivity::class.java)
            intent.putExtra("ID", recipe.id)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return recipes.size
    }
}
