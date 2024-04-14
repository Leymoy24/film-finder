package com.example.filmfinder.di.module

import com.example.filmfinder.di.scope.ActivityScope
import com.example.filmfinder.domain.DeleteFirstQueryUseCase
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
import com.example.filmfinder.domain.GetQueriesCountUseCase
import com.example.filmfinder.domain.GetQueriesUseCase
import com.example.filmfinder.domain.GetReviewsPageUseCase
import com.example.filmfinder.domain.GetSeasonsPageUseCase
import com.example.filmfinder.domain.SearchMoviesPageUseCase
import com.example.filmfinder.domain.SetCurrentMovieUseCase
import com.example.filmfinder.domain.SetCurrentSeasonUseCase
import com.example.filmfinder.domain.SetFiltersUseCase
import com.example.filmfinder.domain.SetQueryUseCase
import com.example.filmfinder.domain.ShiftIdsUseCase
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
        getSeasonsPage: GetSeasonsPageUseCase,
        setCurrentSeason: SetCurrentSeasonUseCase,
        getCurrentSeason: GetCurrentSeasonUseCase,
        getEpisodesPage: GetEpisodesPageUseCase,
        getReviewsPage: GetReviewsPageUseCase,
        searchMoviesPage: SearchMoviesPageUseCase,
        getPosters: GetPostersUseCase,
        getQueries: GetQueriesUseCase,
        setQuery: SetQueryUseCase,
        deleteFirstQuery: DeleteFirstQueryUseCase,
        getQueriesCount: GetQueriesCountUseCase,
        shiftIds: ShiftIdsUseCase
    ): ViewModelFactory = ViewModelFactory(
        getMovies = getMovies,
        getMoviesPage = getMoviesPage,
        getGenres = getGenresUse,
        getCountries = getCountries,
        setFilters = setFilters,
        getFilters = getFilters,
        getCurrentMovie = getCurrentMovie,
        setCurrentMovie = setCurrentMovie,
        getActorsPage = getActorsPage,
        getSeasonsPage = getSeasonsPage,
        setCurrentSeason = setCurrentSeason,
        getCurrentSeason = getCurrentSeason,
        getEpisodesPage = getEpisodesPage,
        getReviewsPage = getReviewsPage,
        searchMoviesPage = searchMoviesPage,
        getPosters = getPosters,
        getQueries = getQueries,
        setQuery = setQuery,
        deleteFirstQuery = deleteFirstQuery,
        getQueriesCount = getQueriesCount,
        shiftIds = shiftIds
    )
}