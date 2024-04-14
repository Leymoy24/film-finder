package com.example.filmfinder.data.network

import com.example.filmfinder.data.model.FieldModel
import com.example.filmfinder.data.network.serializable.ActorModelResponseRemote
import com.example.filmfinder.data.network.serializable.MovieModelResponseRemote
import com.example.filmfinder.data.source.Constants
import com.towich.kinopoiskDev.data.network.serializable.EpisodeModelResponseRemote
import com.towich.kinopoiskDev.data.network.serializable.PosterModelResponseRemote
import com.towich.kinopoiskDev.data.network.serializable.ReviewModelResponseRemote
import com.towich.kinopoiskDev.data.network.serializable.SeasonModelResponseRemote
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

    @GET(ApiRoutes.SEASONS)
    suspend fun getSeasonsByMovieId(
        @Query("page") page: Int,
        @Query("limit") limit: Int = Constants.pageLimit,
        @Query("movieId") movieId: List<String>,
        @Query("selectFields") selectFields: List<String> = Constants.seasonSelectedFields
    ): Response<SeasonModelResponseRemote>


    @GET(ApiRoutes.SEASONS)
    suspend fun getEpisodes(
        @Query("page") page: Int,
        @Query("limit") limit: Int = Constants.pageLimit,
        @Query("movieId") movieId: List<String>,
        @Query("number") number: List<String>,
        @Query("selectFields") selectFields: List<String> = Constants.episodesSelectedFields
    ): Response<EpisodeModelResponseRemote>


    @GET(ApiRoutes.REVIEWS)
    suspend fun getReviews(
        @Query("page") page: Int,
        @Query("limit") limit: Int = Constants.pageLimit,
        @Query("movieId") movieId: List<String>,
        @Query("selectFields") selectFields: List<String> = Constants.reviewsSelectedFields
    ): Response<ReviewModelResponseRemote>

    @GET(ApiRoutes.SEARCH)
    suspend fun searchMovie(
        @Query("page") page: Int,
        @Query("limit") limit: Int = Constants.pageLimit,
        @Query("query") query: String
    ): Response<MovieModelResponseRemote>

    @GET(ApiRoutes.IMAGES)
    suspend fun getImages(
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = Constants.pageLimit,
        @Query("movieId") movieId: List<String>
    ): Response<PosterModelResponseRemote>
}