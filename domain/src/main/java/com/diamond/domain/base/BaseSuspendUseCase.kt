package com.diamond.domain.base

import com.diamond.domain.thread.ExecutionThread
import kotlinx.coroutines.withContext

abstract class BaseSuspendUseCase<in P, R>(
    private val executionThread: ExecutionThread
) {

    suspend operator fun invoke(params: P? = null): R {
        return withContext(executionThread.io) {
            execute(params)
        }
    }

    @Throws(RuntimeException::class)
    protected abstract suspend fun execute(params: P?): R

}