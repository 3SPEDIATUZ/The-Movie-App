package com.example.themovieapp.data.datasource.local

import androidx.lifecycle.LiveData
import com.example.themovieapp.data.datasource.local.dao.MovieDao
import com.example.themovieapp.data.datasource.local.entity.MovieEntity
import javax.inject.Inject

class MovieLocalDataSource @Inject constructor(private val movieDao: MovieDao) {

    fun getAllMovies(): LiveData<List<MovieEntity>> {
        return movieDao.getAllMovies()
    }


    /*suspend fun getAllMovies(): List<MovieEntity> {
        return movieDao.getAllMovies()
    }

    suspend fun getAllMovies(): MovieModelResponse {
        return movieDao.getAllMovies().movieEntityToMovieModelResponse()
    }*/

    suspend fun saveMovies(movies: MovieEntity) {
        movieDao.insert(movies)
    }

    suspend fun insertMovies(movies: List<MovieEntity>) {
        movieDao.insertAll(movies)
    }

    suspend fun clearMovies() {
        movieDao.deleteAllMovies()
    }
}