package com.example.filmfinder.data.model

import com.example.filmfinder.data.room.entity.CountryEntity
import com.example.filmfinder.data.room.entity.GenreEntity

data class FieldModel(
    val name: String,
    val slug: String
) {
    fun convertToChipModel() = ChipModel(name = name)
    fun convertToGenreEntity() = GenreEntity(genre = name)
    fun convertToCountryEntity() = CountryEntity(country = name)
}