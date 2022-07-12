package com.example.themovieapp.domain.model

import com.example.themovieapp.data.database.entity.MovieEntity
import com.example.themovieapp.data.model.MovieModel
import com.example.themovieapp.data.response.MovieResponse

data class Movie(val title: String, val poster: String)

val lisMovieModel: List<MovieModel> = ArrayList()

fun MovieResponse.toDomain() = Movie(title = "title", poster = "poster")
fun MovieEntity.toDomain() = Movie(title, poster)
