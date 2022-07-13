package com.example.themovieapp.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.themovieapp.data.response.MovieResponse
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Query("SELECT * FROM movie_table ORDER BY id DESC")
    fun getAllMovies(): Flow<MovieResponse>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(movies: MovieResponse)

    @Query("DELETE FROM movie_table")
    suspend fun deleteAllMovies()
}