package com.example.filmfinder.domain

import androidx.paging.PagingData
import com.example.filmfinder.data.model.EpisodeModel
import com.example.filmfinder.data.repository.MainRepository
import kotlinx.coroutines.flow.Flow

class GetEpisodesPageUseCase(private val repository: MainRepository) {
    operator fun invoke(): Flow<PagingData<EpisodeModel>> {
        return repository.getEpisodesPage()
    }
}