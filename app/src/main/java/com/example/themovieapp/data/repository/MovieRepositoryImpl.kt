package com.example.themovieapp.data.repository

import androidx.lifecycle.LiveData
import com.example.themovieapp.data.datasource.local.MovieLocalDataSource
import com.example.themovieapp.data.datasource.local.entity.MovieEntity
import com.example.themovieapp.data.datasource.remote.model.MovieModel
import com.example.themovieapp.data.datasource.remote.network.BaseDataSource
import com.example.themovieapp.data.datasource.remote.network.MovieRemoteDataSource
import com.example.themovieapp.data.datasource.remote.response.MovieModelResponse
import com.example.themovieapp.domain.model.*
import com.example.themovieapp.utils.Constants
import com.example.themovieapp.utils.Resource
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource
) : MovieRepository {

    override suspend fun getAllMoviesFromRemote(): Resource<MovieModelResponse> {
       return movieRemoteDataSource.getMoviesFromApi(Constants.API_KEY)
    }

    override fun getAllMoviesFromLocal(): LiveData<List<MovieEntity>> {
        return movieLocalDataSource.getAllMovies()
    }

    /*
     override suspend fun getAllMoviesFromRemote(): List<Movie> {
        val response: List<MovieModel> = movieRemoteDataSource.getMoviesFromApi(Constants.API_KEY)
        return response.listMovieModelToListMovie()
    }

    override suspend fun getAllMoviesFromLocal(): List<Movie> {
        val response: List<MovieEntity> = movieLocalDataSource.getAllMovies()
        return response.listMovieEntityToListMovie()
    }*/

    override suspend fun saveAllMovies(movieEntity: MovieEntity) {
        movieLocalDataSource.saveMovies(movieEntity)
    }

    override suspend fun insert(movieEntity: List<MovieEntity>) {
        if (movieEntity.isNotEmpty()) {
            clearMovies()
            movieLocalDataSource.insertMovies(movieEntity)
        }
    }

    override suspend fun clearMovies() {
        movieLocalDataSource.clearMovies()
    }
}