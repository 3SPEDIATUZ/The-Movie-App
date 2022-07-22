package com.example.themovieapp.data.datasource.remote.network

import com.example.themovieapp.data.datasource.remote.response.MovieModelResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("movie/popular")
    suspend fun getMovies(@Query("api_key") apiKey: String): Response<MovieModelResponse>
}