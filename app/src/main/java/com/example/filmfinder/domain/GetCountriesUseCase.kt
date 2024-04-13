package com.example.filmfinder.domain

import com.example.filmfinder.data.model.FieldModel
import com.example.filmfinder.data.network.ApiResult
import com.example.filmfinder.data.repository.MainRepository

class GetCountriesUseCase(private val repository: MainRepository) {
    suspend operator fun invoke(): ApiResult<List<FieldModel>> {
        return repository.getCountries()
    }
}