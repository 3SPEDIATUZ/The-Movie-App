package com.example.themovieapp.data.datasource.remote.response

import com.example.themovieapp.data.datasource.local.entity.MovieEntity
import com.example.themovieapp.data.datasource.remote.model.MovieModel
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
