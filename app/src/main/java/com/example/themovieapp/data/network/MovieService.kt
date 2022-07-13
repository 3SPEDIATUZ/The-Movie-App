package com.example.themovieapp.data.network

import com.example.themovieapp.data.response.MovieResponse
import com.hadiyarajesh.flower.ApiResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieService @Inject constructor(private val apiService: ApiService) {

    fun getMovies(apiKey: String): Flow<ApiResponse<MovieResponse>> {
        return apiService.getMovies(apiKey)
    }
}