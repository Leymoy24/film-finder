package com.example.filmfinder.ui.screen.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.filmfinder.data.model.MovieModel
import com.example.filmfinder.data.model.PosterModel
import com.example.filmfinder.data.network.ApiResult
import com.example.filmfinder.domain.GetActorsPageUseCase
import com.example.filmfinder.domain.GetCurrentMovieUseCase
import com.example.filmfinder.domain.GetPostersUseCase
import com.example.filmfinder.domain.GetSeasonsPageUseCase
import com.example.filmfinder.domain.SetCurrentSeasonUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MovieViewModel(
    private val getCurrentMovie: GetCurrentMovieUseCase,
    private val getActorsPage: GetActorsPageUseCase,
    private val getSeasonsPage: GetSeasonsPageUseCase,
    private val setCurrentSeason: SetCurrentSeasonUseCase,
    private val getPosters: GetPostersUseCase,
) : ViewModel() {

    private val _posters = MutableStateFlow<List<PosterModel>>(listOf())
    val posters: StateFlow<List<PosterModel>> = _posters

    val actors = getActorsPage().cachedIn(viewModelScope)
    val seasons = getSeasonsPage().cachedIn(viewModelScope)

    fun performGetPosters(){
        viewModelScope.launch {
            when (val result = getPosters()) {
                is ApiResult.Success -> {
                    _posters.value = result.data.docs.map { it.convertToPosterModel() }
                }

                is ApiResult.Error -> {

                }
            }
        }
    }

    fun performGetCurrentMovie(): MovieModel? {
        return getCurrentMovie()
    }

    fun performSetCurrentSeason(seasonNumber: Int?){
        setCurrentSeason(seasonNumber = seasonNumber)
    }
}