package com.diamond.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diamond.domain.usecase.GetDiscoveredMoviesUseCase
import com.diamond.domain.usecase.ObserveDiscoveredMoviesUseCase
import com.diamond.model.DiscoverMovieModel
import com.diamond.presentation.home.HomeFragmentViewModel.DiscoveredMovies.Success
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@HiltViewModel
class HomeFragmentViewModel @Inject constructor(
    private val discoverMoviesUseCase: GetDiscoveredMoviesUseCase,
    private val observeDiscoveredMoviesUseCase: ObserveDiscoveredMoviesUseCase
) : ViewModel() {

    private val _movies = MutableStateFlow<DiscoveredMovies>(DiscoveredMovies.Initial)
    val movies: StateFlow<DiscoveredMovies> get() = _movies.asStateFlow()

    init {
        viewModelScope.launch {
            observeDiscoveredMoviesUseCase.execute().collect {
                _movies.value = Success(data = it.map { movie ->
                    DiscoverMovieModel(
                        id = movie.id,
                        title = movie.title,
                        description = movie.overview,
                        movieIcon = movie.posterPath
                    )
                })
            }
        }
        viewModelScope.launch { discoverMoviesUseCase.invoke() }
    }

    sealed class DiscoveredMovies() {
        object Initial : DiscoveredMovies()
        object Failure : DiscoveredMovies()
        data class Success(val data: List<DiscoverMovieModel>) : DiscoveredMovies()
    }
}