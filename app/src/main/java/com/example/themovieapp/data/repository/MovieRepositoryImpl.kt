package com.example.themovieapp.data.repository

import com.example.themovieapp.data.local.dao.MovieDao
import com.example.themovieapp.data.local.entity.MovieEntity
import com.example.themovieapp.data.local.entity.MovieEntityResponse
import com.example.themovieapp.data.remote.network.MovieRemoteDataSource
import com.example.themovieapp.data.remote.network.MovieRemoteDataSourceImpl
import com.example.themovieapp.data.remote.response.MovieModelResponse
import com.example.themovieapp.domain.model.Movie
import com.example.themovieapp.domain.model.listMovieEntityToListMovie
import com.example.themovieapp.domain.model.listMovieModelToListMovie
import com.example.themovieapp.utils.Constants
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val localDataSource: MovieDao
) : MovieRepository {

    override suspend fun getAllMoviesFromRetrofit(): List<Movie> {
        val movieModelResponse = movieRemoteDataSource.getMovies(Constants.API_KEY)
       return movieModelResponse.listMovieModelToListMovie()
    }

    override suspend fun getAllMoviesFromRoom(): List<Movie> {
        val movieResponseLocal = localDataSource.getAllMovies()
        return movieResponseLocal.listMovieEntityToListMovie()
    }

    override suspend fun insertAllMovies(movies: List<MovieEntity>) {
        localDataSource.insertAll(movies)
    }

    override suspend fun insertMovie(movie: MovieEntity) {
        localDataSource.saveMovie(movie)
    }

    override suspend fun clearMovies() {
        localDataSource.deleteAllMovies()
    }
}