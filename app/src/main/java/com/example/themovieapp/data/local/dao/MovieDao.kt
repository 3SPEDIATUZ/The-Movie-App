package com.example.themovieapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.themovieapp.data.local.entity.MovieEntity

@Dao
interface MovieDao {

    @Query("SELECT * FROM movie_table ORDER BY id ASC")
    suspend fun getAllMovies(): List<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies: MovieEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(quotes:List<MovieEntity>)

    @Query("DELETE FROM movie_table")
    suspend fun deleteAllMovies()
}