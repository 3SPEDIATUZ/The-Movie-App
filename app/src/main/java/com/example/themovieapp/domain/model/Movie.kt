package com.example.themovieapp.domain.model

import com.example.themovieapp.data.datasource.local.entity.MovieEntity
import com.example.themovieapp.data.datasource.local.entity.movieEntityToMovieModel
//import com.example.themovieapp.data.datasource.local.entity.MovieEntityResponse
import com.example.themovieapp.data.datasource.remote.model.MovieModel

data class Movie(val id: Int = 0, val title: String, val poster: String)

//fun <E> List<E>.Hola() = MovieEntityResponse(id = 0, listOf())
fun MovieModel.movieModelToMovie() = Movie(0, this.title, this.poster)
fun MovieEntity.movieEntityToMovie() = Movie(this.id, this.title, this.poster)
fun MovieEntity.movieEntityToMovieModel() = MovieModel(this.title, this.poster)
fun List<MovieEntity>.listMovieEntityToListMovie() = map { it.movieEntityToMovie() }
fun List<MovieModel>.listMovieModelToListMovieEntity() = map { it.movieEntityToMovieModel() }