package com.diamond.domain.usecase

import com.diamond.domain.base.BaseFlowUseCase
import com.diamond.domain.data.MovieDataRepository
import com.diamond.domain.models.movie.MovieDetail
import com.diamond.domain.thread.ExecutionThread
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class ObserveMovieDetailUseCase @Inject constructor(
    executionThread: ExecutionThread,
    private val movieDataRepository: MovieDataRepository
) : BaseFlowUseCase<Int, MovieDetail>(executionThread) {

    override fun build(params: Int?): Flow<MovieDetail> =
        movieDataRepository.observeMovieDetail(params ?: 0)
}