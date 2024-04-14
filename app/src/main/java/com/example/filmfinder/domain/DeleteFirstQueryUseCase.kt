package com.example.filmfinder.domain

import com.example.filmfinder.data.repository.MainRepository

class DeleteFirstQueryUseCase(private val repository: MainRepository) {
    suspend operator fun invoke() {
        repository.deleteFirstQuery()
    }
}