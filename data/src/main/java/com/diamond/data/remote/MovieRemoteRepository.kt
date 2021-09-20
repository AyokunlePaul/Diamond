package com.diamond.data.remote

import com.diamond.data.model.movie.MovieDetailEntity

interface MovieRemoteRepository {
    suspend fun getMoviesList()
    suspend fun getMovieDetail(movieId: Int)
}