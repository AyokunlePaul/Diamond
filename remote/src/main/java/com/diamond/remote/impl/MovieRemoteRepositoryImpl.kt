package com.diamond.remote.impl

import com.diamond.data.local.MovieLocalRepository
import com.diamond.data.remote.MovieRemoteRepository
import com.diamond.remote.BuildConfig
import com.diamond.remote.mapper.discover.DiscoverMovieRemoteModelMapper
import com.diamond.remote.mapper.movie.MovieDetailRemoteModelMapper
import com.diamond.remote.services.MovieService
import javax.inject.Inject
import timber.log.Timber

class MovieRemoteRepositoryImpl @Inject constructor(
    private val service: MovieService,
    private val localRepository: MovieLocalRepository,
    private val discoverMovieRemoteModelMapper: DiscoverMovieRemoteModelMapper,
    private val movieDetailRemoteModelMapper: MovieDetailRemoteModelMapper
) : MovieRemoteRepository {

    override suspend fun getMoviesList() {
        try {
            val queries = hashMapOf<String, Any>(
                "api_key" to BuildConfig.API_KEY,
                "include_adult" to true
            )
            val response = service.discoverMovies(queries)
            val movies = discoverMovieRemoteModelMapper.mapFromList(response.data)
            localRepository.saveDiscoverMovies(movies)
        } catch (exception: Exception) {
            Timber.e(exception)
        }
    }

    override suspend fun getMovieDetail(movieId: Int) = try {
        val queries = hashMapOf<String, Any>(
            "api_key" to BuildConfig.API_KEY
        )
        val movieDetail = movieDetailRemoteModelMapper.mapFrom(service.getMovieDetails(movieId, queries))
        localRepository.saveMovieDetail(movieDetail)
    } catch (exception: Exception) {
        Timber.e(exception)
    }
}