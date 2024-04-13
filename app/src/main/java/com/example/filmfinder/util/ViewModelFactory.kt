package com.example.filmfinder.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.filmfinder.domain.GetCountriesUseCase
import com.example.filmfinder.domain.GetFiltersUseCase
import com.example.filmfinder.domain.GetGenresUseCase
import com.example.filmfinder.domain.GetMoviesPageUseCase
import com.example.filmfinder.domain.GetMoviesUseCase
import com.example.filmfinder.domain.SetFiltersUseCase
import com.example.filmfinder.ui.screen.allmovies.AllMoviesViewModel
import com.example.filmfinder.ui.screen.filters.FiltersViewModel
import com.example.filmfinder.ui.screen.main.MainViewModel
import com.example.filmfinder.ui.screen.movie.MovieViewModel

class ViewModelFactory(
    private val getMovies: GetMoviesUseCase,
    private val getMoviesPage: GetMoviesPageUseCase,
    private val getGenres: GetGenresUseCase,
    private val getCountries: GetCountriesUseCase,
    private val setFilters: SetFiltersUseCase,
    private val getFilters: GetFiltersUseCase,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> {
                MainViewModel(
                    getMovies = getMovies
                ) as T
            }

            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                MovieViewModel(

                ) as T
            }

            modelClass.isAssignableFrom(AllMoviesViewModel::class.java) -> {
                AllMoviesViewModel(
                    getMovies = getMovies,
                    getMoviesPage = getMoviesPage
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

            else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    }
}