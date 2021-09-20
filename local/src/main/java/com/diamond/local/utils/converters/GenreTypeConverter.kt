package com.diamond.local.utils.converters

import androidx.room.TypeConverter
import com.diamond.local.models.movie.GenreLocalModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class GenreTypeConverter {

    @TypeConverter
    fun convertFrom(data: List<GenreLocalModel>): String {
        return Gson().toJson(data)
    }

    @TypeConverter
    fun convertTo(data: String): List<GenreLocalModel> {
        val typeToken = object : TypeToken<List<GenreLocalModel>>() {}.type
        return Gson().fromJson(data, typeToken)
    }
}