package ch.ost.rj.mge.miniprojekt.model

import android.content.Context
import androidx.room.Room
import ch.ost.rj.mge.miniprojekt.model.storage.RecipeDatabase

class RecipeRepository {
    companion object Database {
        @Volatile
        private lateinit var database: RecipeDatabase

        fun initialize(context: Context) {
            database = Room.databaseBuilder(
                context.applicationContext,
                RecipeDatabase::class.java, "recipe-database"
            ).allowMainThreadQueries().build()
        }

        fun getRecipes(): List<Recipe> {
            return database.recipeDao().getAllRecipes()
        }

        fun getRecipeById(id: Int): Recipe {
            return database.recipeDao().getById(id)
        }

        fun addRecipe(recipe: Recipe) {
            database.recipeDao().insert(recipe)
        }

        fun deleteRecipe(recipe: Recipe) {
            database.recipeDao().delete(recipe)
        }
    }
}