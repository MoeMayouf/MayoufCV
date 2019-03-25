package com.example.mayoufcv.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.jetbrains.annotations.Nullable

class StringListConverter {
    private val gson: Gson by lazy {
        Gson()
    }

    @TypeConverter
    fun deserialiseToListOfStrings(rawData: String?): List<String> {
        rawData?.let {
            val listType = object : TypeToken<List<String>>() {}.type
            return gson.fromJson(rawData, listType)
        }
        return emptyList()
    }

    @TypeConverter
    @Nullable
    fun serialiseListOfStrings(data: List<String>) = gson.toJson(data)
}