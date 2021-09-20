package com.diamond.domain.base

import com.diamond.domain.thread.ExecutionThread
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

abstract class BaseFlowUseCase<in Params, T> constructor(
    private val executionThread: ExecutionThread
) {
    /**
     * Function which builds Flow instance based on given arguments
     * @param params initial use case arguments
     */
    protected abstract fun build(params: Params? = null): Flow<T>

    fun execute(params: Params? = null): Flow<T> {
        return this.build(params)
            .flowOn(executionThread.io)
    }
}