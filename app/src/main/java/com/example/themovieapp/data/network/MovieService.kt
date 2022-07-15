package com.example.themovieapp.data.network

import com.example.themovieapp.data.dto.mapper.MovieDTOMapper
import com.example.themovieapp.data.model.MovieModel
import com.example.themovieapp.data.response.MovieModelResponse
import com.example.themovieapp.domain.model.Movie
import com.example.themovieapp.domain.model.MovieResponse
import com.hadiyarajesh.flower.ApiResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieService @Inject constructor(private val apiService: ApiService) {

    suspend fun getMovies(apiKey: String): List<Movie> {
        return withContext(Dispatchers.IO) {
            val response = apiService.getMovies(apiKey)
            val movieModel = response.movie
            val mapper = MovieDTOMapper()
            mapper.mapMovieModelList(movieModel)
        }
    }
}
