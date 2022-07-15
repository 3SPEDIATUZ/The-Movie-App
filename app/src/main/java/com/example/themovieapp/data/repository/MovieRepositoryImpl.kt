package com.example.themovieapp.data.repository

import com.example.themovieapp.data.database.dao.MovieDao
import com.example.themovieapp.data.database.entity.MovieEntity
import com.example.themovieapp.data.database.entity.MovieEntityResponse
import com.example.themovieapp.data.dto.mapper.MovieDTOMapper
import com.example.themovieapp.data.model.MovieModel
import com.example.themovieapp.data.network.MovieService
import com.example.themovieapp.data.response.MovieModelResponse
import com.example.themovieapp.domain.model.Movie
import com.example.themovieapp.domain.model.toDomain
import com.example.themovieapp.utils.Constants
import com.hadiyarajesh.flower.ApiResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieService: MovieService,
    private val movieDao: MovieDao
) : MovieRepository {

    override suspend fun getAllMoviesFromRetrofit(): List<Movie> {
       return movieService.getMovies(Constants.API_KEY)
    }

    override suspend fun getAllMoviesFromRoom(): List<Movie> {
        val response = movieDao.getAllMovies()
        val movieEntity = response.movieEntity
        val mapper = MovieDTOMapper()
       return mapper.mapMovieEntityList(movieEntity)
    }

    override suspend fun insertMovies(movies: MovieEntityResponse) {
        val response = movies.movieEntity
        val mapper = MovieDTOMapper()
        movieDao.insertAll(mapper.mapMovieEntityList(response))
    }

    override suspend fun clearMovies() {
        movieDao.deleteAllMovies()
    }
}