package com.diamond.remote.model.discover

data class DiscoverMovieRemoteModel(
    val id: Int?,
    val poster_path: String?,
    val adult: Boolean?,
    val overview: String?,
    val release_date: String?,
    val original_title: String?,
    val original_language: String?,
    val title: String?,
    val backdrop_path: String?,
    val popularity: Double?,
    val vote_count: Int?,
    val video: Boolean,
    val vote_average: Double?
)
