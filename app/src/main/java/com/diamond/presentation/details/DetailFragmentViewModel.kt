package com.diamond.presentation.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diamond.domain.models.movie.MovieDetail
import com.diamond.domain.usecase.GetMovieDetailsUseCase
import com.diamond.domain.usecase.ObserveMovieDetailUseCase
import com.diamond.presentation.details.DetailFragmentViewModel.MovieDetailResult.Initial
import com.diamond.presentation.details.DetailFragmentViewModel.MovieDetailResult.Successful
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@HiltViewModel
class DetailFragmentViewModel @Inject constructor(
    private val getMovieDetailsUseCase: GetMovieDetailsUseCase,
    private val observeMovieDetailUseCase: ObserveMovieDetailUseCase
) : ViewModel() {

    private val _movieDetail = MutableStateFlow<MovieDetailResult>(Initial)
    val movieDetail: StateFlow<MovieDetailResult> get() = _movieDetail.asStateFlow()

    fun getMovieDetail(movieId: Int) {
        viewModelScope.launch {
            observeMovieDetailUseCase.execute(movieId).collect {
                _movieDetail.value = Successful(it)
            }
        }
        viewModelScope.launch {
            getMovieDetailsUseCase.invoke(movieId)
        }
    }

    sealed class MovieDetailResult() {
        object Initial : MovieDetailResult()
        object Failure : MovieDetailResult()
        data class Successful(val data: MovieDetail) : MovieDetailResult()
    }
}