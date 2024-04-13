package com.example.filmfinder.di.module

import com.example.filmfinder.data.repository.MainRepository
import com.example.filmfinder.di.scope.AppScope
import com.example.filmfinder.domain.GetActorsPageUseCase
import com.example.filmfinder.domain.GetCountriesUseCase
import com.example.filmfinder.domain.GetCurrentMovieUseCase
import com.example.filmfinder.domain.GetFiltersUseCase
import com.example.filmfinder.domain.GetGenresUseCase
import com.example.filmfinder.domain.GetMoviesPageUseCase
import com.example.filmfinder.domain.GetMoviesUseCase
import com.example.filmfinder.domain.SetCurrentMovieUseCase
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
}