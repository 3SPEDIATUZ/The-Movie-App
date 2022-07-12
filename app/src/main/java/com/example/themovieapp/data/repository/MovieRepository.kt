package com.example.themovieapp.data.repository

import com.example.themovieapp.data.database.entity.MovieEntity
import com.example.themovieapp.data.response.MovieResponse
import com.example.themovieapp.domain.model.Movie
import com.skydoves.sandwich.ApiResponse

interface MovieRepository {

    suspend fun getAllMoviesFromApi(): List<Movie>
    suspend fun getAllMoviesFromDatabase():List<Movie>
    suspend fun insertMovies(movies: List<MovieEntity>)
    suspend fun clearMovies()
}