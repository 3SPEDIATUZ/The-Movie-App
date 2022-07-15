package com.example.themovieapp.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.themovieapp.data.database.entity.MovieEntity
import com.example.themovieapp.data.database.entity.MovieEntityResponse
@Dao
interface MovieDao {

    @Query("SELECT * FROM movie_table ORDER BY id DESC")
    fun getAllMovies(): MovieEntityResponse

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(movies: MovieEntityResponse)

    @Query("DELETE FROM movie_table")
    suspend fun deleteAllMovies()
}