package com.example.filmfinder.data.room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.filmfinder.data.room.dao.CountryDao
import com.example.filmfinder.data.room.dao.GenreDao
import com.example.filmfinder.data.room.dao.MovieDao
import com.example.filmfinder.data.room.dao.MovieFavouriteDao
import com.example.filmfinder.data.room.dao.QueryDao
import com.example.filmfinder.data.room.entity.CountryEntity
import com.example.filmfinder.data.room.entity.GenreEntity
import com.example.filmfinder.data.room.entity.MovieEntity
import com.example.filmfinder.data.room.entity.MovieFavouriteEntity
import com.example.filmfinder.data.room.entity.QueryEntity
import com.example.filmfinder.data.util.Converters

@Database(entities = [MovieEntity::class, MovieFavouriteEntity::class, GenreEntity::class, CountryEntity::class, QueryEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class MainDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao
    abstract fun genreDao(): GenreDao
    abstract fun countryDao(): CountryDao
    abstract fun movieFavouriteDao(): MovieFavouriteDao
    abstract fun queryDao(): QueryDao

    companion object {
        private var dbInstance: MainDatabase? = null

        fun getDatabaseInstance(context: Context): MainDatabase {
            synchronized(this) {
                if (dbInstance == null) {
                    dbInstance = Room.databaseBuilder(
                        context.applicationContext,
                        MainDatabase::class.java,
                        "main_db"
                    ).build()
                }
                return dbInstance!!
            }
        }
    }
}