package com.example.themovieapp.data.network

import com.example.themovieapp.data.response.MovieResponse
import com.hadiyarajesh.flower.ApiResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/3/movie/popular")
    fun getMovies(@Query("api_key") apiKey: String): Flow<ApiResponse<MovieResponse>>
}