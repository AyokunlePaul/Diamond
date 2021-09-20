package com.diamond.data.local

import com.diamond.data.model.discover.DiscoverMovieEntity
import com.diamond.data.model.movie.MovieDetailEntity
import kotlinx.coroutines.flow.Flow

interface MovieLocalRepository {
    suspend fun saveMovieDetail(data: MovieDetailEntity)
    suspend fun saveDiscoverMovies(data: List<DiscoverMovieEntity>)
    fun getMovieDetail(movieId: Int): Flow<MovieDetailEntity>
    fun getDiscoverMovies(): Flow<List<DiscoverMovieEntity>>
}