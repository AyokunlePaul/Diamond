package com.diamond.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.diamond.local.database.dao.DiscoverMovieDao
import com.diamond.local.database.dao.MovieDetailDao
import com.diamond.local.models.discover.DiscoverMovieLocalModel
import com.diamond.local.models.movie.MovieDetailLocalModel
import com.diamond.local.utils.converters.GenreTypeConverter

@Database(version = 1, entities = [DiscoverMovieLocalModel::class, MovieDetailLocalModel::class])
@TypeConverters(GenreTypeConverter::class)
abstract class DiamondDatabase : RoomDatabase() {
    abstract fun getMovieDetailDao(): MovieDetailDao
    abstract fun getDiscoverMovieDao(): DiscoverMovieDao
}