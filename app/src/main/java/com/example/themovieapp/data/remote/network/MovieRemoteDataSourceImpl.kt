package com.example.themovieapp.data.remote.network

import com.example.themovieapp.data.remote.model.MovieModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieRemoteDataSourceImpl @Inject constructor(private val movieService: MovieService): MovieRemoteDataSource {

    override suspend fun getMovies(apiKey: String): List<MovieModel> =
        withContext(Dispatchers.IO) {
            movieService.getMovies(apiKey).body()!!.movieModels
        }
}
