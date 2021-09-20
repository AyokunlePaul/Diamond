package com.diamond.domain.usecase

import com.diamond.domain.base.BaseSuspendUseCase
import com.diamond.domain.data.MovieDataRepository
import com.diamond.domain.thread.ExecutionThread
import javax.inject.Inject

class GetDiscoveredMoviesUseCase @Inject constructor(
    executionThread: ExecutionThread,
    private val movieDataRepository: MovieDataRepository
) : BaseSuspendUseCase<Unit, Unit>(executionThread) {

    override suspend fun execute(params: Unit?) {
        movieDataRepository.getMoviesRemote()
    }
}