package com.example.themovieapp.data.repository

import com.example.themovieapp.data.response.MovieResponse
import com.hadiyarajesh.flower.ApiResponse
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    fun getAllMoviesFromRetrofit(): Flow<ApiResponse<MovieResponse>>
    fun getAllMoviesFromRoom(): Flow<MovieResponse>
    suspend fun insertMovies(movies: MovieResponse)
    suspend fun clearMovies()
}