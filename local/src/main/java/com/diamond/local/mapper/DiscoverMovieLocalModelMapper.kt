package com.diamond.local.mapper

import com.diamond.data.mapper.BaseMapper
import com.diamond.data.model.discover.DiscoverMovieEntity
import com.diamond.local.models.discover.DiscoverMovieLocalModel
import javax.inject.Inject

class DiscoverMovieLocalModelMapper @Inject constructor() :
    BaseMapper<DiscoverMovieLocalModel, DiscoverMovieEntity> {

    override fun mapFrom(from: DiscoverMovieLocalModel?): DiscoverMovieEntity {
        return DiscoverMovieEntity(
            id = from?.id.safe,
            posterPath = from?.posterPath.safe,
            adult = from?.adult.safe,
            overview = from?.overview.safe,
            releaseDate = from?.releaseDate.safe,
            originalLanguage = from?.originalLanguage.safe,
            originalTitle = from?.originalTitle.safe,
            title = from?.title.safe,
            backdropPath = from?.backdropPath.safe,
            popularity = from?.popularity.safe,
            voteCount = from?.voteCount.safe,
            voteAverage = from?.voteAverage.safe
        )
    }

    override fun mapTo(to: DiscoverMovieEntity?): DiscoverMovieLocalModel {
        return DiscoverMovieLocalModel(
            id = to?.id.safe,
            posterPath = to?.posterPath.safe,
            adult = to?.adult.safe,
            overview = to?.overview.safe,
            releaseDate = to?.releaseDate.safe,
            originalLanguage = to?.originalLanguage.safe,
            originalTitle = to?.originalTitle.safe,
            title = to?.title.safe,
            backdropPath = to?.backdropPath.safe,
            popularity = to?.popularity.safe,
            voteCount = to?.voteCount.safe,
            voteAverage = to?.voteAverage.safe
        )
    }
}