package com.example.themovieapp.utils

import androidx.room.TypeConverter
import com.example.themovieapp.data.model.MovieModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ConvertersRoom {

    @TypeConverter
    fun fromGroupTaskMemberList(value: List<MovieModel>): String {
        val gson = Gson()
        val type = object : TypeToken<List<MovieModel>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toGroupTaskMemberList(value: String): List<MovieModel> {
        val gson = Gson()
        val type = object : TypeToken<List<MovieModel>>() {}.type
        return gson.fromJson(value, type)
    }
}