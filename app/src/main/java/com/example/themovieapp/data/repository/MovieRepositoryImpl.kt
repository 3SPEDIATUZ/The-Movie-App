package com.example.themovieapp.data.repository

import com.example.themovieapp.data.remote.api.ApiService
import com.example.themovieapp.data.remote.model.MovieResponse
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

    override suspend fun getMoviesPopular(): ApiResponse<MovieResponse> = withContext(ioDispatcher) {
         apiService.getMoviesPopular(Constants.API_KEY)
    }

    override suspend fun getMoviesTop(): ApiResponse<MovieResponse> = withContext(ioDispatcher) {
        apiService.getMoviesTop(Constants.API_KEY)
    }

    override suspend fun getMoviesUpcoming(): ApiResponse<MovieResponse> = withContext(ioDispatcher) {
        apiService.getMoviesUpcoming(Constants.API_KEY)
    }

}