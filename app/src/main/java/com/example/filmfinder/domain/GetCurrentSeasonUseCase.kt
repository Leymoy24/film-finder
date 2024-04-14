package com.example.filmfinder.domain

import com.example.filmfinder.data.repository.MainRepository

class GetCurrentSeasonUseCase(private val repository: MainRepository) {
    operator fun invoke(): Int? {
        return repository.getCurrentSeason()
    }
}