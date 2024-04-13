package com.example.filmfinder.domain

import com.example.filmfinder.data.network.ApiResult
import com.example.filmfinder.data.network.MovieModelResponseRemote
import com.example.filmfinder.data.repository.MainRepository

class GetMoviesUseCase(private val repository: MainRepository) {
    suspend operator fun invoke(): ApiResult<MovieModelResponseRemote> {
        return repository.getMovies()
    }
}