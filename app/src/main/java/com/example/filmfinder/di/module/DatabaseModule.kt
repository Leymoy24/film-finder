package com.example.filmfinder.di.module

import android.content.Context
import com.example.filmfinder.data.room.dao.CountryDao
import com.example.filmfinder.data.room.dao.GenreDao
import com.example.filmfinder.data.room.database.MainDatabase
import com.example.filmfinder.data.room.dao.MovieDao
import com.example.filmfinder.data.room.dao.MovieFavouriteDao
import com.example.filmfinder.di.scope.AppScope
import dagger.Module
import dagger.Provides

@Module
object DatabaseModule {
    @Provides
    @AppScope
    fun provideMainDatabase(context: Context): MainDatabase {
        return MainDatabase.getDatabaseInstance(context)
    }

    @Provides
    @AppScope
    fun provideMovieDao(mainDatabase: MainDatabase): MovieDao {
        return mainDatabase.movieDao()
    }

    @Provides
    @AppScope
    fun provideGenreDao(mainDatabase: MainDatabase): GenreDao {
        return mainDatabase.genreDao()
    }

    @Provides
    @AppScope
    fun provideCountryDao(mainDatabase: MainDatabase): CountryDao {
        return mainDatabase.countryDao()
    }

    @Provides
    @AppScope
    fun provideMovieFavouriteDao(mainDatabase: MainDatabase): MovieFavouriteDao {
        return mainDatabase.movieFavouriteDao()
    }
}