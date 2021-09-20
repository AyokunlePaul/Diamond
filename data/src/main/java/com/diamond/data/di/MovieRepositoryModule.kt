package com.diamond.data.di

import com.diamond.data.impl.MovieDataRepositoryImpl
import com.diamond.domain.data.MovieDataRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class MovieRepositoryModule {

    @Binds
    abstract fun bindMovieRepository(impl: MovieDataRepositoryImpl): MovieDataRepository
}