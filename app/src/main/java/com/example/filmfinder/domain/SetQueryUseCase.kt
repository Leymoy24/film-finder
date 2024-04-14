package com.example.filmfinder.domain

import com.example.filmfinder.data.repository.MainRepository
import com.example.filmfinder.data.room.entity.QueryEntity

class SetQueryUseCase(private val repository: MainRepository) {
    suspend operator fun invoke(query: QueryEntity) {
        repository.insertQuery(query)
    }
}