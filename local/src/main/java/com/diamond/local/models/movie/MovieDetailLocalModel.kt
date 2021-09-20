package com.diamond.local.models.movie

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.diamond.local.models.movie.GenreLocalModel

@Entity(tableName = "movie_detail")
data class MovieDetailLocalModel(
    @PrimaryKey val id: Int,
    val budget: Int,
    val adult: Boolean,
    val genres: List<GenreLocalModel>,
    val homepage: String,
    val originalLanguage: String,
    val originalTitle: String,
    val title: String,
    val popularity: Double,
    val posterPath: String,
    val releaseDate: String,
    val revenue: Int,
    val runtime: Int,
    val status: String,
    val voteAverage: Double,
    val voteCount: Int,
    val overview: String
)