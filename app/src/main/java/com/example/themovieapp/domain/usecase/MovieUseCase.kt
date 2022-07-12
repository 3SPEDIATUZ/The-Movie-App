package com.example.themovieapp.domain.usecase

import com.example.themovieapp.data.repository.MovieRepository
import com.example.themovieapp.domain.model.Movie
import javax.inject.Inject

class MovieUseCase @Inject constructor(private val movieRepository: MovieRepository) {

    suspend operator fun invoke(): List<Movie> {
        val movies = movieRepository.getAllMoviesFromApi()

        if (movies.isNotEmpty()) {
            movieRepository.insertMovies(movies)
            movies
        } else {
            movieRepository.getAllMoviesFromDatabase()
        }
    }
}