package com.example.filmfinder.data.source

import com.example.filmfinder.BuildConfig

object Constants {
    const val API_KEY: String = BuildConfig.API_KEY_KINOPOISK_DEV
    const val pageLimit = 20

    const val genresField = "genres.name"
    const val countriesField = "countries.name"

    val selectedFields = listOf("id", "name", "description", "rating", "poster", "genres", "year", "ageRating")
}