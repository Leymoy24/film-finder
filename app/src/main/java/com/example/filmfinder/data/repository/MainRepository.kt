package com.example.filmfinder.data.repository

import androidx.paging.PagingData
import com.example.filmfinder.data.model.ActorModel
import com.example.filmfinder.data.model.EpisodeModel
import com.example.filmfinder.data.model.FieldModel
import com.example.filmfinder.data.model.MovieModel
import com.example.filmfinder.data.model.ReviewModel
import com.example.filmfinder.data.model.SeasonModel
import com.example.filmfinder.data.network.ApiResult
import com.example.filmfinder.data.network.serializable.MovieModelResponseRemote
import com.example.filmfinder.data.room.entity.MovieEntity
import com.example.filmfinder.data.room.entity.QueryEntity
import com.towich.kinopoiskDev.data.network.serializable.PosterModelResponseRemote
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    suspend fun getMovies(): ApiResult<MovieModelResponseRemote>
    fun getMoviesPage(): Flow<PagingData<MovieModel>>

    suspend fun getGenres(): ApiResult<List<FieldModel>>
    suspend fun getCountries(): ApiResult<List<FieldModel>>

    fun setFilters(listOfFilters: List<String?>)
    fun getFilters(): List<String?>

    fun setCurrentMovie(movie: MovieModel?)
    fun getCurrentMovie(): MovieModel?

    fun getActorsPage(): Flow<PagingData<ActorModel>>
    fun getSeasonsPage(): Flow<PagingData<SeasonModel>>

    fun setCurrentSeason(seasonNumber: Int?)
    fun getCurrentSeason(): Int?

    fun getEpisodesPage(): Flow<PagingData<EpisodeModel>>

    fun getReviewPage(): Flow<PagingData<ReviewModel>>

    fun searchMovieByName(query: String): Flow<PagingData<MovieModel>>

    suspend fun getPosters(): ApiResult<PosterModelResponseRemote>

    // database
    suspend fun getMoviesFromDb(): List<MovieEntity>
    suspend fun getMovieByIdFromDb(id: Int): MovieEntity?
    suspend fun searchMoviesByNameInDb(name: String): List<MovieEntity>
    suspend fun insertMovieIntoDb(movie: MovieEntity)
    suspend fun deleteDb(movie: MovieEntity)
    suspend fun getAllQueries(): List<QueryEntity>
    suspend fun insertQuery(query: QueryEntity)
    suspend fun deleteFirstQuery()
    suspend fun getQueriesCount(): Int
    suspend fun shiftIds()
}