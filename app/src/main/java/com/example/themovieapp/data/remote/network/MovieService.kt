package com.example.themovieapp.data.remote.network

import com.example.themovieapp.data.remote.response.MovieModelResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("/3/movie/popular")
    suspend fun getMovies(@Query("api_key") apiKey: String): Response<MovieModelResponse>
}