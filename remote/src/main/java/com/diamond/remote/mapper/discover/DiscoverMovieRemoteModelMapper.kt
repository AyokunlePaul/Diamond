package com.diamond.remote.mapper.discover

import com.diamond.data.mapper.BaseMapper
import com.diamond.data.model.discover.DiscoverMovieEntity
import com.diamond.remote.model.discover.DiscoverMovieRemoteModel
import javax.inject.Inject

class DiscoverMovieRemoteModelMapper @Inject constructor() :
    BaseMapper<DiscoverMovieRemoteModel, DiscoverMovieEntity> {

    override fun mapFrom(from: DiscoverMovieRemoteModel?): DiscoverMovieEntity {
        return DiscoverMovieEntity(
            id = from?.id.safe,
            posterPath = from?.poster_path.safe,
            adult = from?.adult.safe,
            overview = from?.overview.safe,
            releaseDate = from?.release_date.safe,
            originalTitle = from?.original_title.safe,
            originalLanguage = from?.original_language.safe,
            title = from?.title.safe,
            backdropPath = from?.backdrop_path.safe,
            popularity = from?.popularity.safe,
            voteAverage = from?.vote_average.safe,
            voteCount = from?.vote_count.safe
        )
    }
}