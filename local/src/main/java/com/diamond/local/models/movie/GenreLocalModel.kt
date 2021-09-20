package com.diamond.local.models.movie

import androidx.room.ColumnInfo

data class GenreLocalModel(
    @ColumnInfo(name = "genre_id") val id: Int,
    @ColumnInfo(name = "genre_name") val name: String
)
