package com.diamond.local.models.discover

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "discover_movie")
data class DiscoverMovieLocalModel(
    @PrimaryKey val id: Int,
    val posterPath: String,
    val adult: Boolean,
    val overview: String,
    val releaseDate: String,
    val originalTitle: String,
    val originalLanguage: String,
    val title: String,
    val backdropPath: String,
    val popularity: Double,
    val voteCount: Int,
    val voteAverage: Double
)
