package com.example.themovieapp.data.repository

import com.example.themovieapp.data.model.Movie
import com.skydoves.sandwich.ApiResponse

interface MovieRepository {

    suspend fun getMovies(): ApiResponse<List<Movie>>
}