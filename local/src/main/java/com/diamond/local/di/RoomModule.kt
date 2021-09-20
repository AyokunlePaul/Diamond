package com.diamond.local.di

import android.content.Context
import androidx.room.Room
import com.diamond.local.database.DiamondDatabase
import com.diamond.local.database.dao.DiscoverMovieDao
import com.diamond.local.database.dao.MovieDetailDao
import com.diamond.local.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

    @Provides
    @Singleton
    internal fun provideDiamondDatabase(@ApplicationContext context: Context): DiamondDatabase {
        return Room.databaseBuilder(
            context,
            DiamondDatabase::class.java,
            Constants.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    internal fun provideDiscoverMovieDao(database: DiamondDatabase): DiscoverMovieDao =
        database.getDiscoverMovieDao()

    @Provides
    @Singleton
    internal fun provideMovieDetailDao(database: DiamondDatabase): MovieDetailDao =
        database.getMovieDetailDao()
}