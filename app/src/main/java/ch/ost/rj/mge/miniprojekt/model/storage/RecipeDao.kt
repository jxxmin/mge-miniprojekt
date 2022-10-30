package ch.ost.rj.mge.miniprojekt.model.storage

import androidx.room.*
import ch.ost.rj.mge.miniprojekt.model.Recipe

@Dao
interface RecipeDao {
    @Query("SELECT * FROM recipe")
    fun getAllRecipes(): List<Recipe>

    @Query("SELECT * FROM recipe WHERE id = :id")
    fun getById(id: Int): Recipe

    @Insert
    fun insert(recipe: Recipe)

    @Delete
    fun delete(recipe: Recipe)
}
