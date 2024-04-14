package com.example.filmfinder.domain

import androidx.paging.PagingData
import com.example.filmfinder.data.model.ReviewModel
import com.example.filmfinder.data.repository.MainRepository
import kotlinx.coroutines.flow.Flow

class GetReviewsPageUseCase(private val repository: MainRepository) {
    operator fun invoke(): Flow<PagingData<ReviewModel>> {
        return repository.getReviewPage()
    }
}