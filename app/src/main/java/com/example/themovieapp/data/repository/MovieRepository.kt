package com.example.themovieapp.data.repository

import androidx.lifecycle.LiveData
import com.example.themovieapp.data.local.entity.MovieEntity
import com.example.themovieapp.data.local.entity.MovieEntityResponse
import com.example.themovieapp.data.remote.response.MovieModelResponse
import com.example.themovieapp.domain.model.Movie
import com.example.themovieapp.utils.Resource

interface MovieRepository {

    suspend fun getAllMoviesFromRetrofit(): List<Movie>
    suspend fun getAllMoviesFromRoom(): List<Movie>
    suspend fun insertAllMovies(movies: List<MovieEntity>)
    suspend fun insertMovie(movie: MovieEntity)
    suspend fun clearMovies()
}