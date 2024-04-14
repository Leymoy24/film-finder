package com.example.filmfinder.domain

import androidx.paging.PagingData
import com.example.filmfinder.data.model.SeasonModel
import com.example.filmfinder.data.repository.MainRepository
import kotlinx.coroutines.flow.Flow

class GetSeasonsPageUseCase(private val repository: MainRepository) {
    operator fun invoke(): Flow<PagingData<SeasonModel>> {
        return repository.getSeasonsPage()
    }
}