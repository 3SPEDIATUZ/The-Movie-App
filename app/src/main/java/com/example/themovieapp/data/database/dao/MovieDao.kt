package com.example.themovieapp.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.themovieapp.data.database.entity.MovieEntity

@Dao
interface MovieDao {

    @Query("SELECT * FROM movie_database ORDER BY id DESC")
    suspend fun getAllMovies(): List<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(quotes: List<MovieEntity>)

    @Query("DELETE FROM movie_database")
    suspend fun deleteAllMovies()
}