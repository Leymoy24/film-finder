package com.example.filmfinder.ui.screen.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmfinder.data.model.MovieModel
import com.example.filmfinder.data.network.ApiResult
import com.example.filmfinder.domain.GetMoviesUseCase
import com.example.filmfinder.domain.SetCurrentMovieUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val getMovies: GetMoviesUseCase,
    private val setCurrentMovie: SetCurrentMovieUseCase
) : ViewModel() {

    private val _pagerMovies = MutableStateFlow<List<MovieModel>>(listOf())
    val pagerMovies: StateFlow<List<MovieModel>> = _pagerMovies

    init {
        performGetPagerMovies()
    }

    private fun performGetPagerMovies(){
        viewModelScope.launch {

            when (val result = getMovies()) {
                is ApiResult.Success -> {
                    _pagerMovies.value = result.data.docs.map { it.convertToMovieModel() }
                }

                is ApiResult.Error -> {

                }
            }
        }
    }

    fun performSetCurrentMovie(movie: MovieModel?){
        setCurrentMovie(movie = movie)
    }
}