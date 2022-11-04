package ch.ost.rj.mge.miniprojekt.model

import androidx.room.*;

@Entity
data class Recipe(
    @ColumnInfo(name = "name") val name: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
