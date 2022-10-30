package ch.ost.rj.mge.miniprojekt.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ch.ost.rj.mge.miniprojekt.R

class RecipeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val name: TextView

    init {
        name = view.findViewById(R.id.recipe_name)
    }
}
