package com.diamond.remote.mapper.movie

import com.diamond.data.mapper.BaseMapper
import com.diamond.data.model.movie.MovieDetailEntity
import com.diamond.remote.model.movie.MovieDetailRemoteModel
import javax.inject.Inject

class MovieDetailRemoteModelMapper @Inject constructor(
    private val genreRemoteModelMapper: GenreRemoteModelMapper
) : BaseMapper<MovieDetailRemoteModel, MovieDetailEntity> {

    override fun mapFrom(from: MovieDetailRemoteModel?): MovieDetailEntity {
        return MovieDetailEntity(
            id = from?.id.safe,
            title = from?.title.safe,
            budget = from?.budget.safe,
            adult = from?.adult.safe,
            genres = genreRemoteModelMapper.mapFromList(from?.genres.safe()),
            homepage = from?.homepage.safe,
            originalTitle = from?.original_title.safe,
            originalLanguage = from?.original_language.safe,
            popularity = from?.popularity.safe,
            posterPath = from?.poster_path.safe,
            releaseDate = from?.release_date.safe,
            revenue = from?.revenue.safe,
            runtime = from?.runtime.safe,
            status = from?.status.safe,
            voteAverage = from?.vote_average.safe,
            voteCount = from?.vote_count.safe,
            overview = from?.overview.safe
        )
    }
}