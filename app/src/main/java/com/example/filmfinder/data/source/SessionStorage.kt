package com.example.filmfinder.data.source

import com.example.filmfinder.data.model.FieldModel

class SessionStorage {
    var listOfGenres: List<FieldModel>? = null
    var listOfCountries: List<FieldModel>? = null

    var listOfFilters: List<String?> = List(size = 4) { null }
}