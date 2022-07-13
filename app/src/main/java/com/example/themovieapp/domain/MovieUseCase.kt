package com.example.themovieapp.domain

import com.example.themovieapp.data.repository.MovieRepository
import com.example.themovieapp.data.response.MovieResponse
import com.hadiyarajesh.flower.Resource
import com.hadiyarajesh.flower.networkBoundResource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MovieUseCase @Inject constructor(private val movieRepository: MovieRepository) {

    fun getMovies(): Flow<Resource<MovieResponse>> {
        return networkBoundResource(
            fetchFromLocal = { movieRepository.getAllMoviesFromRoom() },  //Extrae datos de la base de datos local (Room)
            shouldFetchFromRemote = { localData -> localData == null }, //Decide si se debe realizar una solicitud de red(RETROFIT) o usar datos persistentes locales(ROOM) si están disponibles
            fetchFromRemote = { movieRepository.getAllMoviesFromRetrofit() }, //Realiza una operación de solicitud de red(RETROFIT)
            processRemoteResponse = { }, //Procesa el resultado de la respuesta de la red((RETROFIT)) antes de guardar la clase del modelo en la base de datos, como guardar ciertos valores de encabezado
            saveRemoteData = { movieRepository.insertMovies(it)}, //Guarda el resultado de la solicitud de red(RETROFIT) en la base de datos persistente local(ROOM)
            onFetchFailed = { _, _ -> } //Maneja el escenario de falla de solicitud de red (respuesta  HTTP 200..300, excepciones, etc.)
        ).flowOn(Dispatchers.IO)
    }
}