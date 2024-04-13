package com.example.filmfinder.data.model

data class FieldModel(
    val name: String,
    val slug: String
) {
    fun convertToChipModel() = ChipModel(name = name)
}