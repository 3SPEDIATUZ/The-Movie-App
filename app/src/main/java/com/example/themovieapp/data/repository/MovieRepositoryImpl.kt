package com.example.themovieapp.data.repository

import com.example.themovieapp.data.database.dao.MovieDao
import com.example.themovieapp.data.database.entity.MovieEntity
import com.example.themovieapp.data.network.MovieService
import com.example.themovieapp.data.response.MovieResponse
import com.example.themovieapp.di.IoDispatcher
import com.example.themovieapp.domain.model.Movie
import com.example.themovieapp.domain.model.toDomain
import com.example.themovieapp.utils.Constants
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieService: MovieService,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    private val movieDao: MovieDao
) : MovieRepository {

    override suspend fun getAllMoviesFromApi(): List<Movie> {
        val response: List<MovieResponse> = movieService.getMovies(Constants.API_KEY)
        return response.map { it.toDomain() }
    }

    override suspend fun getAllMoviesFromDatabase(): List<Movie> {
        val response: List<MovieEntity> = movieDao.getAllMovies()
        return response.map { it.toDomain() }
    }

    override suspend fun insertMovies(movies: List<MovieEntity>) {
        movieDao.insertAll(movies)
    }

    override suspend fun clearMovies(){
        movieDao.deleteAllMovies()
    }
}