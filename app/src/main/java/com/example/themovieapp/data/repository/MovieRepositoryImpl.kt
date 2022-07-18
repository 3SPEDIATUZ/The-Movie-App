package com.example.themovieapp.data.repository

import com.example.themovieapp.data.local.MovieLocalDataSource
import com.example.themovieapp.data.local.entity.MovieEntity
import com.example.themovieapp.data.remote.network.MovieRemoteDataSource
import com.example.themovieapp.data.remote.response.MovieModelResponse
import com.example.themovieapp.utils.Constants
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource
) : MovieRepository {

    override suspend fun getAllMoviesFromRemote(): MovieModelResponse {
        return movieRemoteDataSource.getMoviesFromApi(Constants.API_KEY)
    }

    override suspend fun getAllMoviesFromLocal(): MovieModelResponse {
        return  movieLocalDataSource.getAllMovies()
    }

    override suspend fun saveAllMovies(movieEntity: MovieEntity) {
        movieLocalDataSource.saveMovies(movieEntity)
    }

    override suspend fun insert(movieEntity: List<MovieEntity>) {
        movieLocalDataSource.insertMovies(movieEntity)
    }

    override suspend fun clearMovies() {
        movieLocalDataSource.clearMovies()
    }
}