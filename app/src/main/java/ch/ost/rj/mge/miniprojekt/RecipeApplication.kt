package ch.ost.rj.mge.miniprojekt

import android.app.Application
import ch.ost.rj.mge.miniprojekt.model.Recipe
import ch.ost.rj.mge.miniprojekt.model.RecipeRepository
import ch.ost.rj.mge.miniprojekt.services.ThemeService

class RecipeApplication : Application() {
    override fun onCreate() {
        super.onCreate();

        RecipeRepository.initialize(applicationContext)
        ThemeService.initialize(applicationContext)

        // only for testing purposes
        //RecipeRepository.addRecipe(Recipe( "Schoggikuchen", "Nehme Schokolade und viel Mehl, dann mischen und noch ein rohes Ei. Danach beii 400 Grad backen!"))
        //RecipeRepository.addRecipe(Recipe("Chässpätzli", "Spätzle Packung öffnen und in Pfanne mit Käse vermischen."))
    }
}
