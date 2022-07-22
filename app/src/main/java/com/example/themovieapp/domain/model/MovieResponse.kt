package com.example.themovieapp.domain.model

import com.example.themovieapp.data.datasource.remote.model.MovieModel

data class MovieResponse(val id: Int = 0, val movie: List<MovieModel>)