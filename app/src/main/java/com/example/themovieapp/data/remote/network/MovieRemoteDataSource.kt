package com.example.themovieapp.data.remote.network

import com.example.themovieapp.data.remote.model.MovieModel
import com.example.themovieapp.data.remote.response.MovieModelResponse

interface MovieRemoteDataSource {

    suspend fun getMoviesFromApi(apiKey: String): List<MovieModel>
    //suspend fun getMoviesFromApi(apiKey: String): List<MovieModel>
}