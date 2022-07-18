package com.example.themovieapp.data.repository

import com.example.themovieapp.data.local.entity.MovieEntity
import com.example.themovieapp.data.remote.response.MovieModelResponse

interface MovieRepository {

    suspend fun getAllMoviesFromRemote(): MovieModelResponse
    suspend fun getAllMoviesFromLocal(): MovieModelResponse
    suspend fun saveAllMovies(movieEntity: MovieEntity)
    suspend fun insert(movieEntity: List<MovieEntity>)
    suspend fun clearMovies()
}