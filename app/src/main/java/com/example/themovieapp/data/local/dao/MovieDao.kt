package com.example.themovieapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.themovieapp.data.local.entity.MovieEntity
import com.example.themovieapp.data.local.entity.MovieEntityResponse
import com.example.themovieapp.data.remote.response.MovieModelResponse

@Dao
interface MovieDao {

    @Query("SELECT * FROM movie_table ORDER BY id DESC")
    fun getAllMovies(): List<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(movies: List<MovieEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovie(movie: MovieEntity)

    @Query("DELETE FROM movie_table")
    suspend fun deleteAllMovies()
}