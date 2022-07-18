package com.example.themovieapp.domain

import com.example.themovieapp.data.local.entity.movieEntityToMovieModel
import com.example.themovieapp.data.local.entity.movieToMovieEntity
import com.example.themovieapp.data.remote.model.movieToMovieModel
import com.example.themovieapp.data.remote.response.MovieModelResponse
import com.example.themovieapp.data.repository.MovieRepository
import com.example.themovieapp.di.IoDispatcher
import com.example.themovieapp.domain.model.movieEntityToMovie
import com.example.themovieapp.domain.model.movieModelToMovie
import com.example.themovieapp.utils.InternetCheck
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) {

    suspend fun getAllMovies(): MovieModelResponse = withContext(ioDispatcher) {
        if (InternetCheck.isNetworkAvailable()) {
            movieRepository.getAllMoviesFromRemote().movieModels.map { movies ->
           //     movieRepository.insert(movies)
                movieRepository.saveAllMovies(movies.movieEntityToMovieModel())
            }
            movieRepository.getAllMoviesFromLocal()
        } else {
            movieRepository.getAllMoviesFromLocal()
        }
    }
}

/* return networkBoundResource(
            fetchFromLocal = { movieRepository.getAllMoviesFromRoom() },  //Extrae datos de la base de datos local (Room)
            shouldFetchFromRemote = { localData -> localData == null }, //Decide si se debe realizar una solicitud de red(RETROFIT) o usar datos persistentes locales(ROOM) si están disponibles
            fetchFromRemote = { movieRepository.getAllMoviesFromRetrofit() }, //Realiza una operación de solicitud de red(RETROFIT)
            processRemoteResponse = { }, //Procesa el resultado de la respuesta de la red((RETROFIT)) antes de guardar la clase del modelo en la base de datos, como guardar ciertos valores de encabezado
            saveRemoteData = { movieRepository.insertMovies(it) }, //Guarda el resultado de la solicitud de red(RETROFIT) en la base de datos persistente local(ROOM)
            onFetchFailed = { errorBody: String?, statusCode: Int -> } //Maneja el escenario de falla de solicitud de red (respuesta  HTTP 200..300, excepciones, etc.)
        ).flowOn(ioDispatcher)*/