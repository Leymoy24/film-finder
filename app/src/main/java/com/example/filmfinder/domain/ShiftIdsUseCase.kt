package com.example.filmfinder.domain

import com.example.filmfinder.data.repository.MainRepository

class ShiftIdsUseCase(private val repository: MainRepository) {
    suspend operator fun invoke() {
        return repository.shiftIds()
    }
}