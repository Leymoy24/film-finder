package com.example.filmfinder.domain

import com.example.filmfinder.data.repository.MainRepository
import com.example.filmfinder.data.room.entity.QueryEntity

class GetQueriesUseCase(private val repository: MainRepository) {
    suspend operator fun invoke(): List<QueryEntity> {
        return repository.getAllQueries()
    }
}