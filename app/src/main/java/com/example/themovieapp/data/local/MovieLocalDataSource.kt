package com.example.themovieapp.data.local

import com.example.themovieapp.data.local.dao.MovieDao
import com.example.themovieapp.data.local.entity.MovieEntity
import com.example.themovieapp.data.remote.response.MovieModelResponse
import com.example.themovieapp.data.remote.response.movieEntityToMovieModelResponse
import javax.inject.Inject

class MovieLocalDataSource @Inject constructor(private val movieDao: MovieDao) {

    suspend fun getAllMovies(): List<MovieEntity> {
        return movieDao.getAllMovies()
    }


    /*suspend fun getAllMovies(): List<MovieEntity> {
        return movieDao.getAllMovies()
    }

    suspend fun getAllMovies(): MovieModelResponse {
        return movieDao.getAllMovies().movieEntityToMovieModelResponse()
    }*/

    suspend fun saveMovies(movies: MovieEntity) {
        movieDao.saveMovies(movies)
    }

    suspend fun insertMovies(movies: List<MovieEntity>) {
        movieDao.insertAll(movies)
    }

    suspend fun clearMovies() {
        movieDao.deleteAllMovies()
    }
}