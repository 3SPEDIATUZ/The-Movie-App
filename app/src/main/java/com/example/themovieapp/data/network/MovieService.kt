package com.example.themovieapp.data.network

import com.example.themovieapp.data.response.MovieResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieService @Inject constructor(private val apiService: ApiService) {

    suspend fun getMovies(apiKey: String): List<MovieResponse> {
        return withContext(Dispatchers.IO) {
            val response = apiService.getMovies(apiKey)
            response.body() ?: emptyList()
        }
    }
}