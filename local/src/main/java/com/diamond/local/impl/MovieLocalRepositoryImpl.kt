package com.diamond.local.impl

import com.diamond.data.local.MovieLocalRepository
import com.diamond.data.model.discover.DiscoverMovieEntity
import com.diamond.data.model.movie.MovieDetailEntity
import com.diamond.local.database.dao.DiscoverMovieDao
import com.diamond.local.database.dao.MovieDetailDao
import com.diamond.local.mapper.DiscoverMovieLocalModelMapper
import com.diamond.local.mapper.MovieDetailLocalModelMapper
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MovieLocalRepositoryImpl @Inject constructor(
    private val movieDetailDao: MovieDetailDao,
    private val discoverMovieDao: DiscoverMovieDao,
    private val discoverMovieLocalModelMapper: DiscoverMovieLocalModelMapper,
    private val movieDetailLocalModelMapper: MovieDetailLocalModelMapper
) : MovieLocalRepository {

    override suspend fun saveMovieDetail(data: MovieDetailEntity) {
        movieDetailDao.saveMovieDetail(
            movieDetailLocalModelMapper.mapTo(data)
        )
    }

    override suspend fun saveDiscoverMovies(data: List<DiscoverMovieEntity>) {
        discoverMovieDao.saveDiscoverMovies(
            discoverMovieLocalModelMapper.mapToList(data)
        )
    }

    override fun getMovieDetail(movieId: Int): Flow<MovieDetailEntity> =
        movieDetailDao.getMovieDetail(movieId).map {
            movieDetailLocalModelMapper.mapFrom(it)
        }

    override fun getDiscoverMovies(): Flow<List<DiscoverMovieEntity>> =
        discoverMovieDao.getDiscoverMovies().map {
            discoverMovieLocalModelMapper.mapFromList(it)
        }
}