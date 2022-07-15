package com.example.themovieapp.domain

import com.example.themovieapp.data.database.entity.toDatabase
import com.example.themovieapp.data.dto.mapper.MovieDTOMapper
import com.example.themovieapp.data.repository.MovieRepository
import com.example.themovieapp.data.response.MovieModelResponse
import com.example.themovieapp.di.IoDispatcher
import com.example.themovieapp.domain.model.Movie
import com.hadiyarajesh.flower.Resource
import com.hadiyarajesh.flower.networkBoundResource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MovieUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(): List<Movie> {
       val movies = movieRepository.getAllMoviesFromRetrofit()

        return if(movies.isNotEmpty()) {
            movieRepository.clearMovies()
            movieRepository.insertMovies()
            movies
        } else {
            movieRepository.getAllMoviesFromRoom()
        }
    }
}

/*val response = movieDao.getAllMovies()
        val movieEntity = response.movieEntity
        val mapper = MovieDTOMapper()
       return mapper.mapMovieEntityList(movieEntity)*/

/* return networkBoundResource(
            fetchFromLocal = { movieRepository.getAllMoviesFromRoom() },  //Extrae datos de la base de datos local (Room)
            shouldFetchFromRemote = { localData -> localData == null }, //Decide si se debe realizar una solicitud de red(RETROFIT) o usar datos persistentes locales(ROOM) si están disponibles
            fetchFromRemote = { movieRepository.getAllMoviesFromRetrofit() }, //Realiza una operación de solicitud de red(RETROFIT)
            processRemoteResponse = { }, //Procesa el resultado de la respuesta de la red((RETROFIT)) antes de guardar la clase del modelo en la base de datos, como guardar ciertos valores de encabezado
            saveRemoteData = { movieRepository.insertMovies(it) }, //Guarda el resultado de la solicitud de red(RETROFIT) en la base de datos persistente local(ROOM)
            onFetchFailed = { errorBody: String?, statusCode: Int -> } //Maneja el escenario de falla de solicitud de red (respuesta  HTTP 200..300, excepciones, etc.)
        ).flowOn(ioDispatcher)*/