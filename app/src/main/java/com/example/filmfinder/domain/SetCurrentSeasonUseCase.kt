package com.example.filmfinder.domain

import com.example.filmfinder.data.repository.MainRepository

class SetCurrentSeasonUseCase(private val repository: MainRepository) {
    operator fun invoke(seasonNumber: Int?) {
        repository.setCurrentSeason(seasonNumber = seasonNumber)
    }
}