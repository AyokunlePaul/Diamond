package com.diamond.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.diamond.local.models.discover.DiscoverMovieLocalModel
import kotlinx.coroutines.flow.Flow

@Dao
interface DiscoverMovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveDiscoverMovie(data: DiscoverMovieLocalModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveDiscoverMovies(data: List<DiscoverMovieLocalModel>)

    @Query("SELECT * FROM discover_movie")
    fun getDiscoverMovies(): Flow<List<DiscoverMovieLocalModel>>
}