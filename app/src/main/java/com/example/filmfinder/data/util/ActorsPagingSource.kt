package com.example.filmfinder.data.util

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.filmfinder.data.model.ActorModel
import com.example.filmfinder.data.network.ApiService
import com.example.filmfinder.data.source.SessionStorage

class ActorsPagingSource(
    private val apiService: ApiService,
    private val sessionStorage: SessionStorage
) : PagingSource<Int, ActorModel>() {
    override fun getRefreshKey(state: PagingState<Int, ActorModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ActorModel> {
        val page = params.key ?: 1
        return try {
            val response = apiService.getActorsByMovieId(
                page = page,
                movieId = sessionStorage.currentMovie!!.id.toString()
            )

            LoadResult.Page(
                data = response.body()!!.docs.map { it.convertToActorModel() },
                prevKey = if (page == 1) null else page.minus(1),
                nextKey = if (response.body()!!.docs.isEmpty()) null else page.plus(1),
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}