package com.example.filmfinder.data.util

import androidx.room.TypeConverter

class Converters {
    @TypeConverter
    fun fromString(value: String?): List<String>? {
        return value?.split(",")?.map { it.trim() }
    }

    @TypeConverter
    fun fromList(list: List<String>?): String? {
        return list?.joinToString(", ")?.trim()
    }
}