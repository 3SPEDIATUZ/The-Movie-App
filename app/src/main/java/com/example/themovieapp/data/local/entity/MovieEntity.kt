package com.example.themovieapp.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.themovieapp.domain.model.Movie

@Entity(tableName = "movie_table")
data class MovieEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Long = 0,
    @ColumnInfo(name = "original_title") val title: String,
    @ColumnInfo(name = "poster_path") val poster: String
)

fun Movie.movieToMovieEntity() = MovieEntity(id, title, poster)
fun List<Movie>.listMovieToListEntity() = map { it.movieToMovieEntity() }
