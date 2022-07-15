package com.example.themovieapp.utils

import androidx.room.TypeConverter
import com.example.themovieapp.data.database.entity.MovieEntity
import com.example.themovieapp.data.model.MovieModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ConvertersRoom {

    @TypeConverter
    fun fromGroupTaskMemberList(value: List<MovieEntity>): String {
        val gson = Gson()
        val type = object : TypeToken<List<MovieEntity>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toGroupTaskMemberList(value: String): List<MovieEntity> {
        val gson = Gson()
        val type = object : TypeToken<List<MovieEntity>>() {}.type
        return gson.fromJson(value, type)
    }
}