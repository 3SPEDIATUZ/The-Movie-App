package com.example.themovieapp.data.remote.model

import com.example.themovieapp.data.local.entity.MovieEntity
import com.example.themovieapp.domain.model.Movie
import com.google.gson.annotations.SerializedName

data class MovieModel(
    @SerializedName("original_title") val title: String,
    @SerializedName("poster_path") val poster: String
)

fun Movie.movieToMovieModel() = MovieModel(this.title, this.poster)
fun List<Movie>.listMovieToListMovieModel() = map { it.movieToMovieModel() }
fun MovieEntity.toMovieModel() = MovieModel(this.title, this.poster)
fun List<MovieEntity>.toHola() = map { it.toMovieModel() }
