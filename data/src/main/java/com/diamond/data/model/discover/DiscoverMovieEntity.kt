package com.diamond.data.model.discover

data class DiscoverMovieEntity(
    val id: Int,
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
