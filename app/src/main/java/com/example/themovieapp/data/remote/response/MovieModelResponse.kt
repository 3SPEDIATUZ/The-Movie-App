package com.example.themovieapp.data.remote.response

import com.example.themovieapp.data.local.entity.MovieEntity
import com.example.themovieapp.data.remote.model.MovieModel
import com.example.themovieapp.domain.model.Movie
import com.example.themovieapp.domain.model.movieEntityToMovieModel
import com.google.gson.annotations.SerializedName

data class MovieModelResponse(
    @SerializedName("results") val movieModels: List<MovieModel>
)

fun List<MovieEntity>.movieEntityToMovieModelResponse(): MovieModelResponse {
    val result = mutableListOf<MovieModel>()
    this.map { movieEntity ->
        result.add(movieEntity.movieEntityToMovieModel())
    }
    return MovieModelResponse(result)
}
