package com.example.themovieapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.themovieapp.data.database.dao.MovieDao
import com.example.themovieapp.data.database.entity.MovieEntity

@Database(entities = [MovieEntity::class], version = 1)
abstract class MovieDatabase: RoomDatabase() {

    abstract fun movieDao(): MovieDao
}