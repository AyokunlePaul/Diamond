package com.diamond.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.diamond.local.models.movie.MovieDetailLocalModel
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDetailDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovieDetail(data: MovieDetailLocalModel)

    @Query("SELECT * FROM movie_detail WHERE id = :movieId")
    fun getMovieDetail(movieId: Int): Flow<MovieDetailLocalModel>
}