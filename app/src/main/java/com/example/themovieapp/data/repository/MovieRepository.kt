package com.example.themovieapp.data.repository

import androidx.lifecycle.LiveData
import com.example.themovieapp.data.datasource.local.entity.MovieEntity
import com.example.themovieapp.data.datasource.remote.response.MovieModelResponse
import com.example.themovieapp.domain.model.Movie
import com.example.themovieapp.utils.Resource

interface MovieRepository {

    suspend fun getAllMoviesFromRemote(): Resource<MovieModelResponse>
     fun getAllMoviesFromLocal(): LiveData<List<MovieEntity>>
    suspend fun saveAllMovies(movieEntity: MovieEntity)
    suspend fun insert(movieEntity: List<MovieEntity>)
    suspend fun clearMovies()

    /*suspend fun getAllMoviesFromRemote(): List<Movie>
    suspend fun getAllMoviesFromLocal(): List<Movie>*/
}