package com.example.themovieapp.domain.model

import com.example.themovieapp.data.model.MovieModel

data class MovieResponse(val id: Int = 0, val movie: List<MovieModel>)

fun List<Movie>.toHola() = MovieResponse(id = 0, listOf())