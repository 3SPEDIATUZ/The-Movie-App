package com.example.themovieapp.data.api

import com.example.themovieapp.data.model.MovieResponse
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    //Obtendremos las peliculas populares.
    @GET("/3/movie/popular")
    suspend fun getMoviesPopular(@Query("api_key") apiKey: String): ApiResponse<MovieResponse>

    //obtendremos las peliculas top
    @GET("/3/movie/top_rated")// ->endPoint (punto final)
    suspend fun getMoviesTop(@Query("api_key") apiKey: String) : ApiResponse<MovieResponse>

    //obtendremos las peliculas exclusivas
    @GET("/3/movie/upcoming")
    suspend fun getMoviesUpcoming (@Query("api_key") apiKey: String) : ApiResponse<MovieResponse>

}