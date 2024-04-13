package com.example.filmfinder.data.network

import com.example.filmfinder.data.model.FieldModel
import com.example.filmfinder.data.source.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(ApiRoutes.MOVIES)
    suspend fun getMovies(
        @Query("page") page: Int,
        @Query("limit") limit: Int = Constants.pageLimit,
        @Query("selectFields") selectFields: List<String> = Constants.movieSelectedFields,
        @Query("genres.name") genre: String? = null,
        @Query("countries.name") country: String? = null,
        @Query("year") year: String? = null,
        @Query("ageRating") age: String? = null
    ): Response<MovieModelResponseRemote>

    @GET(ApiRoutes.POSSIBLE_VALUES_BY_FIELD)
    suspend fun getAllPossibleValuesByField(
        @Query("field") field: String
    ): Response<List<FieldModel>>

    @GET(ApiRoutes.ACTORS)
    suspend fun getActorsByMovieId(
        @Query("page") page: Int,
        @Query("limit") limit: Int = Constants.pageLimit,
        @Query("movies.id") movieId: String,
        @Query("selectFields") selectFields: List<String> = Constants.actorSelectedFields,
    ): Response<ActorModelResponseRemote>
}