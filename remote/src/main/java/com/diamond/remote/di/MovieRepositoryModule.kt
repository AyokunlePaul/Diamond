package com.diamond.remote.di

import com.diamond.data.remote.MovieRemoteRepository
import com.diamond.remote.impl.MovieRemoteRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class MovieRepositoryModule {

    @Binds
    internal abstract fun bindMovieRemoteRepository(impl: MovieRemoteRepositoryImpl): MovieRemoteRepository
}