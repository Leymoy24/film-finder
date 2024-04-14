package com.example.filmfinder.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.filmfinder.domain.GetActorsPageUseCase
import com.example.filmfinder.domain.GetCountriesUseCase
import com.example.filmfinder.domain.GetCurrentMovieUseCase
import com.example.filmfinder.domain.GetCurrentSeasonUseCase
import com.example.filmfinder.domain.GetEpisodesPageUseCase
import com.example.filmfinder.domain.GetFiltersUseCase
import com.example.filmfinder.domain.GetGenresUseCase
import com.example.filmfinder.domain.GetMoviesPageUseCase
import com.example.filmfinder.domain.GetMoviesUseCase
import com.example.filmfinder.domain.GetPostersUseCase
import com.example.filmfinder.domain.GetReviewsPageUseCase
import com.example.filmfinder.domain.GetSeasonsPageUseCase
import com.example.filmfinder.domain.SearchMoviesPageUseCase
import com.example.filmfinder.domain.SetCurrentMovieUseCase
import com.example.filmfinder.domain.SetCurrentSeasonUseCase
import com.example.filmfinder.domain.SetFiltersUseCase
import com.example.filmfinder.ui.screen.allmovies.AllMoviesViewModel
import com.example.filmfinder.ui.screen.episodes.EpisodesViewModel
import com.example.filmfinder.ui.screen.filters.FiltersViewModel
import com.example.filmfinder.ui.screen.main.MainViewModel
import com.example.filmfinder.ui.screen.movie.MovieViewModel
import com.towich.kinopoiskDev.ui.screen.reviews.ReviewsViewModel

class ViewModelFactory(
    private val getMovies: GetMoviesUseCase,
    private val getMoviesPage: GetMoviesPageUseCase,
    private val getGenres: GetGenresUseCase,
    private val getCountries: GetCountriesUseCase,
    private val setFilters: SetFiltersUseCase,
    private val getFilters: GetFiltersUseCase,
    private val getCurrentMovie: GetCurrentMovieUseCase,
    private val setCurrentMovie: SetCurrentMovieUseCase,
    private val getActorsPage: GetActorsPageUseCase,
    private val getSeasonsPage: GetSeasonsPageUseCase,
    private val setCurrentSeason: SetCurrentSeasonUseCase,
    private val getCurrentSeason: GetCurrentSeasonUseCase,
    private val getEpisodesPage: GetEpisodesPageUseCase,
    private val getReviewsPage: GetReviewsPageUseCase,
    private val searchMoviesPage: SearchMoviesPageUseCase,
    private val getPosters: GetPostersUseCase,
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> {
                MainViewModel(
                    getMovies = getMovies,
                    setCurrentMovie = setCurrentMovie
                ) as T
            }

            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                MovieViewModel(
                    getCurrentMovie = getCurrentMovie,
                    getActorsPage = getActorsPage,
                    getSeasonsPage = getSeasonsPage,
                    setCurrentSeason = setCurrentSeason,
                    getPosters = getPosters
                ) as T
            }

            modelClass.isAssignableFrom(AllMoviesViewModel::class.java) -> {
                AllMoviesViewModel(
                    getMovies = getMovies,
                    getMoviesPage = getMoviesPage,
                    setCurrentMovie = setCurrentMovie,
                    searchMoviesPage = searchMoviesPage
                ) as T
            }

            modelClass.isAssignableFrom(FiltersViewModel::class.java) -> {
                FiltersViewModel(
                    getGenres = getGenres,
                    getCountries = getCountries,
                    setFilters = setFilters,
                    getFilters = getFilters
                ) as T
            }

            modelClass.isAssignableFrom(EpisodesViewModel::class.java) -> {
                EpisodesViewModel(
                    getEpisodesPage = getEpisodesPage,
                    getCurrentSeason = getCurrentSeason
                ) as T
            }

            modelClass.isAssignableFrom(ReviewsViewModel::class.java) -> {
                ReviewsViewModel(
                    getReviewsPage = getReviewsPage
                ) as T
            }

            else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    }
}