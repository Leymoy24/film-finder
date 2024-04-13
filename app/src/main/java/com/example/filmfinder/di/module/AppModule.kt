package com.example.filmfinder.di.module

import com.example.filmfinder.data.network.ApiService
import com.example.filmfinder.data.repository.MainRepository
import com.example.filmfinder.data.repository.MainRepositoryImpl
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
        sessionStorage: SessionStorage
    ): MainRepository {
        return MainRepositoryImpl(
            apiService = apiService,
            sessionStorage = sessionStorage
        )
    }

    @Provides
    @AppScope
    fun provideSessionStorage(): SessionStorage {
        return SessionStorage()
    }
}