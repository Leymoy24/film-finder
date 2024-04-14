package com.example.filmfinder.ui.screen.episodes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.filmfinder.domain.GetCurrentSeasonUseCase
import com.example.filmfinder.domain.GetEpisodesPageUseCase

class EpisodesViewModel(
    private val getEpisodesPage: GetEpisodesPageUseCase,
    private val getCurrentSeason: GetCurrentSeasonUseCase,
) : ViewModel() {

    val episodes = getEpisodesPage().cachedIn(viewModelScope)

    fun performGetCurrentSeason(): Int? {
        return getCurrentSeason()
    }
}