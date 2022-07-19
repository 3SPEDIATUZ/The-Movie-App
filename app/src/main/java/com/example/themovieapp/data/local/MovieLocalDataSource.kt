package com.example.themovieapp.data.local

import com.example.themovieapp.data.local.dao.MovieDao
import com.example.themovieapp.data.local.entity.MovieEntity
import javax.inject.Inject

class MovieLocalDataSource @Inject constructor(private val movieDao: MovieDao) {

    suspend fun getAllMovies(): List<MovieEntity>{
        return  movieDao.getAllMovies()
    }

    suspend fun saveMovies (movie : MovieEntity){
        return movieDao.saveMovie(movie)
    }

}