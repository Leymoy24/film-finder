package com.example.filmfinder.data.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.filmfinder.data.model.FieldModel

@Entity(tableName = "genres_table")
data class GenreEntity(
    @PrimaryKey(autoGenerate = false)
    val genre: String
) {
    fun convertToFieldModel() = FieldModel(genre, "")
}