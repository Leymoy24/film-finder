package com.example.filmfinder.domain

import com.example.filmfinder.data.repository.MainRepository

class GetFiltersUseCase(private val repository: MainRepository) {
    operator fun invoke(): List<String?> {
        return repository.getFilters()
    }
}