package com.example.themovieapp.data.local

import com.example.themovieapp.data.local.dao.MovieDao
import com.example.themovieapp.data.local.entity.MovieEntity
import javax.inject.Inject

class MovieLocalDataSource @Inject constructor(private val movieDao: MovieDao) {

    suspend fun saveMovies (movie : MovieEntity){
        return movieDao.saveMovie(movie)
    }

    //Movie Categority
    suspend fun  getUpcomingMovies(): List<MovieEntity>{
        return movieDao.getAllMovies().filter { it.movieType =="upcoming" }
    }

    suspend fun  getTopRatedMovies(): List<MovieEntity>{
        return movieDao.getAllMovies().filter { it.movieType == "toprated" }
    }

    suspend fun  getPopularMovies(): List<MovieEntity>{
        return movieDao.getAllMovies().filter { it.movieType == "popular" }
    }

}