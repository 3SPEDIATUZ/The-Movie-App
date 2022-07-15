package com.example.themovieapp.data.repository

import com.example.themovieapp.data.database.entity.MovieEntity
import com.example.themovieapp.data.database.entity.MovieEntityResponse
import com.example.themovieapp.data.response.MovieModelResponse
import com.example.themovieapp.domain.model.Movie
import com.hadiyarajesh.flower.ApiResponse
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

   suspend fun getAllMoviesFromRetrofit(): List<Movie>
   suspend fun getAllMoviesFromRoom(): List<Movie>
    suspend fun insertMovies(movies: MovieEntityResponse)
    suspend fun clearMovies()
}