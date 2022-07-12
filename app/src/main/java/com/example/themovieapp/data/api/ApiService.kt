package com.example.themovieapp.data.api

import com.example.themovieapp.data.response.MovieResponse
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/3/movie/popular")
    suspend fun getMovies(@Query("api_key") apiKey: String): ApiResponse<MovieResponse>
}