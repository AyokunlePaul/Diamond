package com.diamond.data.impl

import com.diamond.data.local.MovieLocalRepository
import com.diamond.data.remote.MovieRemoteRepository
import com.diamond.domain.data.MovieDataRepository
import com.diamond.domain.models.discover.DiscoverMovie
import com.diamond.domain.models.movie.Genre
import com.diamond.domain.models.movie.MovieDetail
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MovieDataRepositoryImpl @Inject constructor(
    private val remoteRepository: MovieRemoteRepository,
    private val localRepository: MovieLocalRepository
) : MovieDataRepository {

    override fun discoverMovies(): Flow<List<DiscoverMovie>> {
        return localRepository.getDiscoverMovies().map {
            it.map { entity ->
                DiscoverMovie(
                    id = entity.id,
                    title = entity.title,
                    posterPath = entity.posterPath,
                    overview = entity.overview
                )
            }
        }
    }

    override suspend fun getMoviesRemote() = remoteRepository.getMoviesList()

    override fun observeMovieDetail(movieId: Int): Flow<MovieDetail> {
        return localRepository.getMovieDetail(movieId).map { from ->
            MovieDetail(
                id = from.id,
                title = from.title,
                budget = from.budget,
                genres = from.genres.map { genreEntity ->
                    Genre(
                        id = genreEntity.id,
                        name = genreEntity.name
                    )
                },
                homepage = from.homepage,
                originalTitle = from.originalTitle,
                originalLanguage = from.originalLanguage,
                popularity = from.popularity,
                posterPath = from.posterPath,
                releaseDate = from.releaseDate,
                revenue = from.revenue,
                runtime = from.runtime,
                status = from.status,
                voteAverage = from.voteAverage,
                voteCount = from.voteCount,
                overview = from.overview,
                adult = from.adult
            )
        }
    }

    override suspend fun getMovieDetail(movieId: Int) = remoteRepository.getMovieDetail(movieId)
}