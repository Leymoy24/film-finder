package com.example.filmfinder.domain

import com.example.filmfinder.data.model.MovieModel
import com.example.filmfinder.data.repository.MainRepository

class SetCurrentMovieUseCase(private val repository: MainRepository) {
    operator fun invoke(movie: MovieModel?) {
        repository.setCurrentMovie(movie)
    }
}