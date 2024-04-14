package com.example.filmfinder.domain

import com.example.filmfinder.data.network.ApiResult
import com.example.filmfinder.data.repository.MainRepository
import com.towich.kinopoiskDev.data.network.serializable.PosterModelResponseRemote

class GetPostersUseCase(private val repository: MainRepository) {
    suspend operator fun invoke(): ApiResult<PosterModelResponseRemote> {
        return repository.getPosters()
    }
}