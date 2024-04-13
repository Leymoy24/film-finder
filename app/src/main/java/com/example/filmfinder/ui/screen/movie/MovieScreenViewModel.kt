package com.example.filmfinder.ui.screen.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.filmfinder.data.model.ActorModel
import com.example.filmfinder.data.model.MovieModel
import com.example.filmfinder.domain.GetActorsPageUseCase
import com.example.filmfinder.domain.GetCurrentMovieUseCase
import kotlinx.coroutines.flow.Flow

class MovieViewModel(
    private val getCurrentMovie: GetCurrentMovieUseCase,
    private val getActorsPage: GetActorsPageUseCase,
) : ViewModel() {

    fun performGetActors(): Flow<PagingData<ActorModel>> = getActorsPage().cachedIn(viewModelScope)

    fun performGetCurrentMovie(): MovieModel? {
        return getCurrentMovie()
    }
}