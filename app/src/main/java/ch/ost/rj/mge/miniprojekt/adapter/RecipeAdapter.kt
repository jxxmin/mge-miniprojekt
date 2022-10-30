package ch.ost.rj.mge.miniprojekt.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ch.ost.rj.mge.miniprojekt.R
import ch.ost.rj.mge.miniprojekt.model.Recipe
import ch.ost.rj.mge.miniprojekt.model.RecipeRepository

class RecipeAdapter() :
    RecyclerView.Adapter<RecipeViewHolder>() {
    private var recipes: List<Recipe> = ArrayList<Recipe>(RecipeRepository.getRecipes())

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_overview_layout, parent, false)

        return RecipeViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = this.recipes[position]
        holder.name.text = recipe.name
    }

    override fun getItemCount(): Int {
        return recipes.size
    }
}
