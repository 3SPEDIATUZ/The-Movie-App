package com.example.themovieapp.data.repository

import com.example.themovieapp.data.api.ApiService
import com.example.themovieapp.data.model.Movie
import com.example.themovieapp.data.model.MovieReponse
import com.example.themovieapp.di.IoDispatcher
import com.example.themovieapp.utils.Constants
import com.skydoves.sandwich.ApiResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : MovieRepository {

    override suspend fun getMovies(): ApiResponse<MovieReponse> = withContext(ioDispatcher) {
         apiService.getMovies(Constants.API_KEY)
    }

    override suspend fun getMoviesTop(): ApiResponse<MovieReponse> = withContext(ioDispatcher) {
        apiService.getMoviesTop(Constants.API_KEY)
    }

    override suspend fun getMoviesUpcoming(): ApiResponse<MovieReponse> = withContext(ioDispatcher) {
        apiService.getMoviesUpcoming(Constants.API_KEY)
    }

}