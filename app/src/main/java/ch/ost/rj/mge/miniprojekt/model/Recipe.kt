package ch.ost.rj.mge.miniprojekt.model

import androidx.room.*;

@Entity
data class Recipe(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String,
)
