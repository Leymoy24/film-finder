package com.example.filmfinder.di.module

import com.example.filmfinder.data.repository.MainRepository
import com.example.filmfinder.di.scope.AppScope
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
import dagger.Module
import dagger.Provides

@Module
object DomainModule {

    @Provides
    @AppScope
    fun provideGetMoviesUseCase(repository: MainRepository): GetMoviesUseCase {
        return GetMoviesUseCase(repository = repository)
    }

    @Provides
    @AppScope
    fun provideGetMoviesPageUseCase(repository: MainRepository): GetMoviesPageUseCase {
        return GetMoviesPageUseCase(repository = repository)
    }

    @Provides
    @AppScope
    fun provideGetGenresUseCase(repository: MainRepository): GetGenresUseCase {
        return GetGenresUseCase(repository = repository)
    }

    @Provides
    @AppScope
    fun provideGetCountriesUseCase(repository: MainRepository): GetCountriesUseCase {
        return GetCountriesUseCase(repository = repository)
    }

    @Provides
    @AppScope
    fun provideSetFiltersUseCase(repository: MainRepository): SetFiltersUseCase {
        return SetFiltersUseCase(repository = repository)
    }

    @Provides
    @AppScope
    fun provideGetFiltersUseCase(repository: MainRepository): GetFiltersUseCase {
        return GetFiltersUseCase(repository = repository)
    }

    @Provides
    @AppScope
    fun provideGetCurrentMovieUseCase(repository: MainRepository): GetCurrentMovieUseCase {
        return GetCurrentMovieUseCase(repository = repository)
    }

    @Provides
    @AppScope
    fun provideSetCurrentMovieUseCase(repository: MainRepository): SetCurrentMovieUseCase {
        return SetCurrentMovieUseCase(repository = repository)
    }

    @Provides
    @AppScope
    fun provideGetActorsPageUseCase(repository: MainRepository): GetActorsPageUseCase {
        return GetActorsPageUseCase(repository = repository)
    }

    @Provides
    @AppScope
    fun provideGetSeasonsPageUseCase(repository: MainRepository): GetSeasonsPageUseCase {
        return GetSeasonsPageUseCase(repository = repository)
    }

    @Provides
    @AppScope
    fun provideGetCurrentSeasonUseCase(repository: MainRepository): GetCurrentSeasonUseCase {
        return GetCurrentSeasonUseCase(repository = repository)
    }

    @Provides
    @AppScope
    fun provideSetCurrentSeasonUseCase(repository: MainRepository): SetCurrentSeasonUseCase {
        return SetCurrentSeasonUseCase(repository = repository)
    }

    @Provides
    @AppScope
    fun provideGetEpisodesPageUseCase(repository: MainRepository): GetEpisodesPageUseCase {
        return GetEpisodesPageUseCase(repository = repository)
    }

    @Provides
    @AppScope
    fun provideGetReviewsPageUseCase(repository: MainRepository): GetReviewsPageUseCase {
        return GetReviewsPageUseCase(repository = repository)
    }

    @Provides
    @AppScope
    fun provideSearchMoviesPageUseCase(repository: MainRepository): SearchMoviesPageUseCase {
        return SearchMoviesPageUseCase(repository = repository)
    }

    @Provides
    @AppScope
    fun provideGetPostersUseCase(repository: MainRepository): GetPostersUseCase {
        return GetPostersUseCase(repository = repository)
    }
}