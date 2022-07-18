package com.example.themovieapp.data.repository

import com.example.themovieapp.data.local.entity.MovieEntity
import com.example.themovieapp.data.remote.response.MovieModelResponse
import com.example.themovieapp.domain.model.Movie

interface MovieRepository {

    suspend fun getAllMoviesFromRemote(): List<Movie>
    suspend fun getAllMoviesFromLocal(): List<Movie>
    suspend fun saveAllMovies(movieEntity: MovieEntity)
    suspend fun insert(movieEntity: List<MovieEntity>)
    suspend fun clearMovies()

    /*suspend fun getAllMoviesFromRemote(): List<Movie>
    suspend fun getAllMoviesFromLocal(): List<Movie>*/
}