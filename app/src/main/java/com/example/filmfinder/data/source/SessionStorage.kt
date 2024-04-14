package com.example.filmfinder.data.source

import com.example.filmfinder.data.model.FieldModel
import com.example.filmfinder.data.model.MovieModel

class SessionStorage {
    var listOfGenres: List<FieldModel>? = null
    var listOfCountries: List<FieldModel>? = null

    var listOfFilters: List<String?> = List(size = 4) { null }

    var currentMovie: MovieModel? = null
    var currentSeason: Int? = null
}