package com.example.themovieapp.data.repository

import com.example.themovieapp.data.model.Movie
import com.example.themovieapp.data.model.MovieReponse
import com.skydoves.sandwich.ApiResponse

interface MovieRepository {

    suspend fun getMovies(): ApiResponse<MovieReponse>
}