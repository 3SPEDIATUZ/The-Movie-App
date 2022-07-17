package com.example.themovieapp.domain.model

import com.example.themovieapp.data.local.entity.MovieEntity
import com.example.themovieapp.data.local.entity.MovieEntityResponse
import com.example.themovieapp.data.remote.model.MovieModel

data class Movie(val id: Long = 0, val title: String, val poster: String)

fun <E> List<E>.Hola() = MovieEntityResponse(id = 0, listOf())
fun MovieModel.movieModelToMovie() = Movie(0, this.title, this.poster)
fun MovieEntity.movieEntityToMovie() = Movie(this.id, this.title, this.poster)
fun List<MovieModel>.listMovieModelToListMovie() = map { it.movieModelToMovie() }
fun List<MovieEntity>.listMovieEntityToListMovie() = map { it.movieEntityToMovie() }