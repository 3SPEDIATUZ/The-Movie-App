package com.example.themovieapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.themovieapp.data.database.dao.MovieDao
import com.example.themovieapp.data.response.MovieResponse
import com.example.themovieapp.utils.ConvertersRoom

@Database(entities = [MovieResponse::class], version = 1)
@TypeConverters(ConvertersRoom::class)
abstract class MovieDatabase: RoomDatabase() {

    abstract fun movieDao(): MovieDao
}