package com.example.themovieapp.data.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.themovieapp.data.datasource.local.dao.MovieDao
import com.example.themovieapp.data.datasource.local.entity.MovieEntity
import com.example.themovieapp.utils.ConvertersRoom

@Database(entities = [MovieEntity::class], version = 1)
@TypeConverters(ConvertersRoom::class)
abstract class MovieDatabase: RoomDatabase() {

    abstract fun movieDao(): MovieDao
}