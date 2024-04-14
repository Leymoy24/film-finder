package com.example.filmfinder.di.module

import android.content.Context
import android.net.ConnectivityManager
import com.example.filmfinder.data.network.ApiService
import com.example.filmfinder.data.repository.MainRepository
import com.example.filmfinder.data.repository.MainRepositoryImpl
import com.example.filmfinder.data.room.dao.CountryDao
import com.example.filmfinder.data.room.dao.GenreDao
import com.example.filmfinder.data.room.dao.MovieDao
import com.example.filmfinder.data.source.SessionStorage
import com.example.filmfinder.di.scope.AppScope
import dagger.Module
import dagger.Provides

@Module
object AppModule {

    @Provides
    @AppScope
    fun provideMainRepository(
        apiService: ApiService,
        sessionStorage: SessionStorage,
        movieDao: MovieDao,
        genreDao: GenreDao,
        countryDao: CountryDao,
        connectivityManager: ConnectivityManager,
        context: Context
    ): MainRepository {
        return MainRepositoryImpl(
            apiService = apiService,
            sessionStorage = sessionStorage,
            movieDao = movieDao,
            genreDao = genreDao,
            countryDao = countryDao,
            connectivityManager = connectivityManager,
            context = context
        )
    }

    @Provides
    @AppScope
    fun provideSessionStorage(): SessionStorage {
        return SessionStorage()
    }

    @Provides
    @AppScope
    fun provideConnectivityManager(context: Context): ConnectivityManager {
        return context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }
}