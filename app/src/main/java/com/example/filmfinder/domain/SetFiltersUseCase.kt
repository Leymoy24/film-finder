package com.example.filmfinder.domain

import com.example.filmfinder.data.repository.MainRepository

class SetFiltersUseCase(private val repository: MainRepository) {
    operator fun invoke(listOfFilters: List<String?>) {
        return repository.setFilters(listOfFilters = listOfFilters)
    }
}