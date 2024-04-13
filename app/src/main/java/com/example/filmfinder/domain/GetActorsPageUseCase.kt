package com.example.filmfinder.domain

import androidx.paging.PagingData
import com.example.filmfinder.data.model.ActorModel
import com.example.filmfinder.data.repository.MainRepository
import kotlinx.coroutines.flow.Flow

class GetActorsPageUseCase(private val repository: MainRepository) {
    operator fun invoke(): Flow<PagingData<ActorModel>> {
        return repository.getActorsPage()
    }
}