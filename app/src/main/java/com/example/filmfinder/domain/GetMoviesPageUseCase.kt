package com.example.filmfinder.domain

import androidx.paging.PagingData
import com.example.filmfinder.data.model.MovieModel
import com.example.filmfinder.data.repository.MainRepository
import kotlinx.coroutines.flow.Flow

class GetMoviesPageUseCase(private val repository: MainRepository) {
    operator fun invoke(): Flow<PagingData<MovieModel>> {
        return repository.getMoviesPage()
    }
}