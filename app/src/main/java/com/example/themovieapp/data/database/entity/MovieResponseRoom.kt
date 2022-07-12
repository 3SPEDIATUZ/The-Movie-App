package com.example.themovieapp.data.database.entity

import androidx.room.ColumnInfo
import com.example.themovieapp.domain.model.Movie
import com.example.themovieapp.domain.model.lisMovieModel

data class MovieResponseRoom(@ColumnInfo(name = "results") val movieModels: List<MovieEntity>)

fun Movie.toDatabase() = MovieResponseRoom(movieModels)
