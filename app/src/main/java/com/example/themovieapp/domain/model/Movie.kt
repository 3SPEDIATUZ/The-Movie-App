package com.example.themovieapp.domain.model

import com.example.themovieapp.data.database.entity.MovieEntity
import com.example.themovieapp.data.model.MovieModel

data class Movie(val id: Int = 0, val title: String, val poster: String)

fun MovieModel.toDomain() = Movie(id = 0, title, poster)
fun MovieEntity.toDomain() = Movie(id, title, poster)