package com.diamond.local.mapper

import com.diamond.data.mapper.BaseMapper
import com.diamond.data.model.movie.MovieDetailEntity
import com.diamond.local.mapper.movie.GenreLocalModelMapper
import com.diamond.local.models.movie.MovieDetailLocalModel
import javax.inject.Inject

class MovieDetailLocalModelMapper @Inject constructor(
    private val genreLocalModelMapper: GenreLocalModelMapper
) : BaseMapper<MovieDetailLocalModel, MovieDetailEntity> {

    override fun mapFrom(from: MovieDetailLocalModel?): MovieDetailEntity {
        return MovieDetailEntity(
            id = from?.id.safe,
            title = from?.title.safe,
            budget = from?.budget.safe,
            adult = from?.adult.safe,
            genres = genreLocalModelMapper.mapFromList(from?.genres.safe()),
            homepage = from?.homepage.safe,
            originalTitle = from?.originalTitle.safe,
            originalLanguage = from?.originalLanguage.safe,
            popularity = from?.popularity.safe,
            posterPath = from?.posterPath.safe,
            releaseDate = from?.releaseDate.safe,
            revenue = from?.revenue.safe,
            runtime = from?.runtime.safe,
            status = from?.status.safe,
            voteAverage = from?.voteAverage.safe,
            voteCount = from?.voteCount.safe,
            overview = from?.overview.safe
        )
    }

    override fun mapTo(to: MovieDetailEntity?): MovieDetailLocalModel {
        return MovieDetailLocalModel(
            id = to?.id.safe,
            title = to?.title.safe,
            adult = to?.adult.safe,
            budget = to?.budget.safe,
            genres = genreLocalModelMapper.mapToList(to?.genres.safe()),
            homepage = to?.homepage.safe,
            originalTitle = to?.originalTitle.safe,
            originalLanguage = to?.originalLanguage.safe,
            popularity = to?.popularity.safe,
            posterPath = to?.posterPath.safe,
            releaseDate = to?.releaseDate.safe,
            revenue = to?.revenue.safe,
            runtime = to?.runtime.safe,
            status = to?.status.safe,
            voteAverage = to?.voteAverage.safe,
            voteCount = to?.voteCount.safe,
            overview = to?.overview.safe
        )
    }
}