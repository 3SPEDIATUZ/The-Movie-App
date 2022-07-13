package com.example.themovieapp.data.repository

import com.example.themovieapp.data.database.dao.MovieDao
import com.example.themovieapp.data.network.MovieService
import com.example.themovieapp.data.response.MovieResponse
import com.example.themovieapp.di.IoDispatcher
import com.example.themovieapp.utils.Constants
import com.hadiyarajesh.flower.ApiResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieService: MovieService,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    private val movieDao: MovieDao
) : MovieRepository {

    override fun getAllMoviesFromRetrofit(): Flow<ApiResponse<MovieResponse>> {
        return movieService.getMovies(Constants.API_KEY)
    }

    override fun getAllMoviesFromRoom(): Flow<MovieResponse> {
        return movieDao.getAllMovies()
    }

    override suspend fun insertMovies(movies: MovieResponse) {
        movieDao.insertAll(movies)
    }

    override suspend fun clearMovies(){
        movieDao.deleteAllMovies()
    }
}