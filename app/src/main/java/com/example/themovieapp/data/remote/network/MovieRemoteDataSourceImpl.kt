package com.example.themovieapp.data.remote.network

import com.example.themovieapp.data.remote.model.MovieModel
import com.example.themovieapp.data.remote.response.MovieModelResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieRemoteDataSourceImpl @Inject constructor(private val movieService: MovieService): MovieRemoteDataSource {

    override suspend fun getMoviesFromApi(apiKey: String): MovieModelResponse = movieService.getMovies(apiKey)
}
