package ch.ost.rj.mge.miniprojekt

import android.app.Application
import ch.ost.rj.mge.miniprojekt.model.Recipe
import ch.ost.rj.mge.miniprojekt.model.RecipeRepository

class RecipeApplication : Application() {
    override fun onCreate() {
        super.onCreate();

        RecipeRepository.initialize(applicationContext)

        // only for testing purposes
        // RecipeRepository.addRecipe(Recipe(1, "Schoggikuchen"))
        // RecipeRepository.addRecipe(Recipe(2, "Chässpätzli"))
    }
}
