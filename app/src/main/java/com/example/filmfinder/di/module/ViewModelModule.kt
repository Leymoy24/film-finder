package com.example.filmfinder.di.module

import com.example.filmfinder.di.scope.ActivityScope
import com.example.filmfinder.domain.GetActorsPageUseCase
import com.example.filmfinder.domain.GetCountriesUseCase
import com.example.filmfinder.domain.GetCurrentMovieUseCase
import com.example.filmfinder.domain.GetFiltersUseCase
import com.example.filmfinder.domain.GetGenresUseCase
import com.example.filmfinder.domain.GetMoviesPageUseCase
import com.example.filmfinder.domain.GetMoviesUseCase
import com.example.filmfinder.domain.SetCurrentMovieUseCase
import com.example.filmfinder.domain.SetFiltersUseCase
import com.example.filmfinder.util.ViewModelFactory
import dagger.Module
import dagger.Provides

@Module
object ViewModelModule {

    @Provides
    @ActivityScope
    fun provideViewModelFactory(
        getMovies: GetMoviesUseCase,
        getMoviesPage: GetMoviesPageUseCase,
        getGenresUse: GetGenresUseCase,
        getCountries: GetCountriesUseCase,
        setFilters: SetFiltersUseCase,
        getFilters: GetFiltersUseCase,
        getCurrentMovie: GetCurrentMovieUseCase,
        setCurrentMovie: SetCurrentMovieUseCase,
        getActorsPage: GetActorsPageUseCase,
    ): ViewModelFactory = ViewModelFactory(
        getMovies = getMovies,
        getMoviesPage = getMoviesPage,
        getGenres = getGenresUse,
        getCountries = getCountries,
        setFilters = setFilters,
        getFilters = getFilters,
        getCurrentMovie = getCurrentMovie,
        setCurrentMovie = setCurrentMovie,
        getActorsPage = getActorsPage
    )
}