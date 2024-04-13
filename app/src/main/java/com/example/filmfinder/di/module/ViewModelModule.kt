package com.example.filmfinder.di.module

import com.example.filmfinder.di.scope.ActivityScope
import com.example.filmfinder.domain.GetCountriesUseCase
import com.example.filmfinder.domain.GetFiltersUseCase
import com.example.filmfinder.domain.GetGenresUseCase
import com.example.filmfinder.domain.GetMoviesPageUseCase
import com.example.filmfinder.domain.GetMoviesUseCase
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
        getFilters: GetFiltersUseCase
    ): ViewModelFactory = ViewModelFactory(
        getMovies = getMovies,
        getMoviesPage = getMoviesPage,
        getGenres = getGenresUse,
        getCountries = getCountries,
        setFilters = setFilters,
        getFilters = getFilters
    )
}