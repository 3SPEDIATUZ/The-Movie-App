package com.example.themovieapp.data.dto.mapper

import com.example.themovieapp.data.database.entity.MovieEntity
import com.example.themovieapp.data.model.MovieModel
import com.example.themovieapp.domain.model.Movie

class MovieDTOMapper {

    private fun mapModel(movieModel: MovieModel): Movie {
        return Movie(0, movieModel.title, movieModel.poster)
    }

    private fun mapEntity(movieEntity: MovieEntity): Movie {
       return Movie(0, movieEntity.title, movieEntity.poster)
    }

    fun mapMovieModelList(listMovieModel: List<MovieModel>): List<Movie> {
        return listMovieModel.map { mapModel(it) }
    }

    fun mapMovieEntityList(listMovieEntity: List<MovieEntity>): List<Movie> {
        return listMovieEntity.map { mapEntity(it) }
    }
}