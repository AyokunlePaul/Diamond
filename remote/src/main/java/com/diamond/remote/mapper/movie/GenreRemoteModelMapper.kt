package com.diamond.remote.mapper.movie

import com.diamond.data.mapper.BaseMapper
import com.diamond.data.model.movie.GenreEntity
import com.diamond.remote.model.movie.GenreRemoteModel
import javax.inject.Inject

class GenreRemoteModelMapper @Inject constructor() : BaseMapper<GenreRemoteModel, GenreEntity> {

    override fun mapFrom(from: GenreRemoteModel?): GenreEntity {
        return GenreEntity(
            id = from?.id.safe,
            name = from?.name.safe
        )
    }
}