package com.diamond.domain.di

import com.diamond.domain.thread.DiamondExecutionThread
import com.diamond.domain.thread.ExecutionThread
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class ExecutionThreadModule {

    @Binds
    internal abstract fun bindExecutionThread(impl: DiamondExecutionThread): ExecutionThread
}