package com.example.themovieapp.data.repository

import com.example.themovieapp.data.response.MovieResponse
import com.skydoves.sandwich.ApiResponse

interface MovieRepository {

    suspend fun getMovies(): ApiResponse<MovieResponse>
}