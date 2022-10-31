package ch.ost.rj.mge.miniprojekt

import android.app.Application
import ch.ost.rj.mge.miniprojekt.model.RecipeRepository
import ch.ost.rj.mge.miniprojekt.services.ThemeService

class RecipeApplication : Application() {
    override fun onCreate() {
        super.onCreate();

        RecipeRepository.initialize(applicationContext)
        ThemeService.initialize(applicationContext)

        // only for testing purposes
        // RecipeRepository.addRecipe(Recipe(1, "Schoggikuchen"))
        // RecipeRepository.addRecipe(Recipe(2, "Chässpätzli"))
    }
}
