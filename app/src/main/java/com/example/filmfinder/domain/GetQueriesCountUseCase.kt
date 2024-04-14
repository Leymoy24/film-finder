package com.example.filmfinder.domain

import com.example.filmfinder.data.repository.MainRepository

class GetQueriesCountUseCase(private val repository: MainRepository) {
    suspend operator fun invoke(): Int {
        return repository.getQueriesCount()
    }
}