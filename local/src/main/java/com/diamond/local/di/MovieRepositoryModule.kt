package com.diamond.local.di

import com.diamond.data.local.MovieLocalRepository
import com.diamond.local.impl.MovieLocalRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class MovieRepositoryModule {

    @Binds
    @Singleton
    internal abstract fun bindMovieRepository(impl: MovieLocalRepositoryImpl): MovieLocalRepository
}