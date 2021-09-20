package com.diamond.domain.usecase

import com.diamond.domain.base.BaseFlowUseCase
import com.diamond.domain.data.MovieDataRepository
import com.diamond.domain.models.discover.DiscoverMovie
import com.diamond.domain.thread.ExecutionThread
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class ObserveDiscoveredMoviesUseCase @Inject constructor(
    executionThread: ExecutionThread,
    private val movieDataRepository: MovieDataRepository
) : BaseFlowUseCase<Unit, List<DiscoverMovie>>(executionThread) {

    override fun build(params: Unit?): Flow<List<DiscoverMovie>> {
        return movieDataRepository.discoverMovies()
    }
}