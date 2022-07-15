package com.example.themovieapp.data.network

import com.example.themovieapp.domain.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/3/movie/popular")
    suspend fun getMovies(@Query("api_key") apiKey: String): MovieResponse
}