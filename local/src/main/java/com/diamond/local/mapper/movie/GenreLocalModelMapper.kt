package com.diamond.local.mapper.movie

import com.diamond.data.mapper.BaseMapper
import com.diamond.data.model.movie.GenreEntity
import com.diamond.local.models.movie.GenreLocalModel
import javax.inject.Inject

class GenreLocalModelMapper @Inject constructor() : BaseMapper<GenreLocalModel, GenreEntity> {

    override fun mapFrom(from: GenreLocalModel?): GenreEntity {
        return GenreEntity(
            id = from?.id.safe,
            name = from?.name.safe
        )
    }

    override fun mapTo(to: GenreEntity?): GenreLocalModel {
        return GenreLocalModel(
            id = to?.id.safe,
            name = to?.name.safe
        )
    }
}