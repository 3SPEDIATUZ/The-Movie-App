package com.example.themovieapp.data.repository

import com.example.themovieapp.data.api.ApiService
import com.example.themovieapp.data.model.Movie
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

    override suspend fun getMovies(): ApiResponse<List<Movie>> = withContext(ioDispatcher) {
         apiService.getMovies(Constants.API_KEY)
    }
}