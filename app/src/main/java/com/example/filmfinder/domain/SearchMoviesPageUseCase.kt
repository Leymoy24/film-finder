package com.example.filmfinder.domain

import androidx.paging.PagingData
import com.example.filmfinder.data.model.MovieModel
import com.example.filmfinder.data.repository.MainRepository
import kotlinx.coroutines.flow.Flow

class SearchMoviesPageUseCase(private val repository: MainRepository) {
    operator fun invoke(query: String): Flow<PagingData<MovieModel>> {
        return repository.searchMovieByName(query = query)
    }
}