package com.example.themovieapp.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.themovieapp.data.response.MovieResponse
import com.example.themovieapp.domain.model.Movie

@Entity(tableName = "movie_database")
data class MovieEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "original_title") val title: String,
    @ColumnInfo(name = "poster_path") val poster: String
)
