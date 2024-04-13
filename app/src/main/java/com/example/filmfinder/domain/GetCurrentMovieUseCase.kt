package com.example.filmfinder.domain

import com.example.filmfinder.data.model.MovieModel
import com.example.filmfinder.data.repository.MainRepository

class GetCurrentMovieUseCase(private val repository: MainRepository) {
    operator fun invoke(): MovieModel? {
        return repository.getCurrentMovie()
    }
}