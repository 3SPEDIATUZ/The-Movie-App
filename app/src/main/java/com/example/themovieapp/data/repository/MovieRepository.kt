package com.example.themovieapp.data.repository

import com.example.themovieapp.data.model.MovieResponse
import com.skydoves.sandwich.ApiResponse

interface MovieRepository {

    suspend fun getMoviesPopular(): ApiResponse<MovieResponse>

    suspend fun getMoviesTop(): ApiResponse<MovieResponse>

    suspend fun getMoviesUpcoming(): ApiResponse<MovieResponse>
}