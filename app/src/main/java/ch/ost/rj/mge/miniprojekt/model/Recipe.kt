package ch.ost.rj.mge.miniprojekt.model

import androidx.room.*;

@Entity
data class Recipe(
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "image") val image: String,
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
