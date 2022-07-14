package com.example.themovieapp.data.dto.mapper

import com.example.themovieapp.domain.entity.MovieEntity

class MovieDTOMapper {

    private fun mapDTO(movieDTO: MovieDTO): MovieEntity {
        return MovieEntity(movieDTO.id, movieDTO.title, movieDTO.poster)
    }

    private fun mapEntity(movieEntity: MovieEntity): MovieDTO {
       return MovieDTO(movieEntity.id, movieEntity.title, movieEntity.poster)
    }

    fun mapMovieDtoList(movieList: List<MovieDTO>): List<MovieEntity> {
        return movieList.map { mapDTO(it) }
    }
}