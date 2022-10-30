package ch.ost.rj.mge.miniprojekt.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ch.ost.rj.mge.miniprojekt.R
import ch.ost.rj.mge.miniprojekt.adapter.RecipeAdapter

class OverviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_overview)

        val recyclerView = findViewById<RecyclerView>(R.id.recipes_list)
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.adapter = RecipeAdapter()
    }
}
