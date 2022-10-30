package ch.ost.rj.mge.miniprojekt.model.storage

import androidx.room.*
import ch.ost.rj.mge.miniprojekt.model.Recipe

@Database(entities = [Recipe::class], version = 1, exportSchema = false)
abstract class RecipeDatabase : RoomDatabase() {
    abstract fun recipeDao(): RecipeDao
}
