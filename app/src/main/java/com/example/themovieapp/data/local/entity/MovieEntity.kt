package com.example.themovieapp.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.themovieapp.data.remote.model.MovieModel
import com.example.themovieapp.domain.model.Movie

@Entity(tableName = "movie_table", indices = [Index(value = ["id"], unique = true)])
data class MovieEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "original_title") val title: String,
    @ColumnInfo(name = "poster_path") val poster: String
)
fun MovieModel.movieEntityToMovieModel() = MovieEntity(0, this.title, this.poster)
fun Movie.movieToMovieEntity() = MovieEntity(id, title, poster)
fun List<Movie>.listMovieToListEntity() = map { it.movieToMovieEntity() }
