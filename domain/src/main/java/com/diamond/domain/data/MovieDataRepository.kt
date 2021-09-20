package com.diamond.domain.data

import com.diamond.domain.models.discover.DiscoverMovie
import com.diamond.domain.models.movie.MovieDetail
import kotlinx.coroutines.flow.Flow

interface MovieDataRepository {

    fun discoverMovies(): Flow<List<DiscoverMovie>>

    suspend fun getMoviesRemote()

    fun observeMovieDetail(movieId: Int): Flow<MovieDetail>

    suspend fun getMovieDetail(movieId: Int)
}