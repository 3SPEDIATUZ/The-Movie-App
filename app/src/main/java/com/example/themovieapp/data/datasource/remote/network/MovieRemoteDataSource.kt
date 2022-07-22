package com.example.themovieapp.data.datasource.remote.network

import javax.inject.Inject

class MovieRemoteDataSource @Inject constructor(private val movieService: MovieService): BaseDataSource() {

    suspend fun getMoviesFromApi(apiKey: String) = getResults { movieService.getMovies(apiKey) }
    //override suspend fun getMoviesFromApi(apiKey: String): List<MovieModel> = movieService.getMovies(apiKey).movieModels
}
