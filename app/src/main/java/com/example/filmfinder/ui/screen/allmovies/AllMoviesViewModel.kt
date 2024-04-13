package com.example.filmfinder.ui.screen.allmovies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.filmfinder.data.model.MovieModel
import com.example.filmfinder.domain.GetMoviesPageUseCase
import com.example.filmfinder.domain.GetMoviesUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AllMoviesViewModel @Inject constructor(
    private val getMovies: GetMoviesUseCase,
    private val getMoviesPage: GetMoviesPageUseCase
) : ViewModel() {

    fun performGetMovies(): Flow<PagingData<MovieModel>> = getMoviesPage().cachedIn(viewModelScope)
}