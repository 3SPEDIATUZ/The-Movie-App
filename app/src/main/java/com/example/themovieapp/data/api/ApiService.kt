package com.example.themovieapp.data.api

import com.example.themovieapp.data.model.Movie
import com.example.themovieapp.data.model.MovieReponse
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    //Obtendremos las peliculas populares.
    @GET("/3/movie/popular")
    suspend fun getMovies(@Query("api_key") apiKey: String): ApiResponse<MovieReponse>

    //obtendremos las peliculas top
    @GET("/3/movie/top_rated")// ->endPoint (punto final)
    suspend fun getMoviesTop(@Query("api_key") apiKey: String) : ApiResponse<MovieReponse>

    //obtendremos las peliculas exclusivas
    @GET("/3//movie/upcoming")
    suspend fun getMoviesUpcoming (@Query("api_key") apiKey: String) : ApiResponse<MovieReponse>

}