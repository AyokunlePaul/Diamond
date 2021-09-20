package com.diamond.data.model.movie

data class MovieDetailEntity(
    val id: Int,
    val budget: Int,
    val adult: Boolean,
    val genres: List<GenreEntity>,
    val homepage: String,
    val originalLanguage: String,
    val originalTitle: String,
    val title: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val releaseDate: String,
    val revenue: Int,
    val runtime: Int,
    val status: String,
    val voteAverage: Double,
    val voteCount: Int
)
