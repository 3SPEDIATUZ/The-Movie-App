package com.example.themovieapp.domain

import com.example.themovieapp.data.datasource.local.entity.movieEntityToMovieModel
import com.example.themovieapp.data.datasource.local.entity.movieToMovieEntity
import com.example.themovieapp.data.repository.MovieRepository
import com.example.themovieapp.di.IoDispatcher
import com.example.themovieapp.domain.model.Movie
import com.example.themovieapp.domain.model.listMovieModelToListMovieEntity
import com.example.themovieapp.utils.InternetCheck
import com.example.themovieapp.utils.performGetOperation
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) {

    fun getAllMovies() = performGetOperation(
        databaseQuery = { movieRepository.getAllMoviesFromLocal() },
        networkCall = { movieRepository.getAllMoviesFromRemote() },
        saveCallResult = { movieRepository.insert(it.movieModels.listMovieModelToListMovieEntity()) })
}

/*suspend fun getAllMovies(): List<Movie> = withContext(ioDispatcher) {
        val movie = movieRepository.getAllMoviesFromRemote()
        if (InternetCheck.isNetworkAvailable()) {
            if (movie.isNotEmpty()) {
                movieRepository.clearMovies()
                //movieRepository.insert(movie.map { it.movieEntityToMovieModel() })
                movie.map { movieRepository.saveAllMovies(it.movieToMovieEntity()) }
            }
            movieRepository.getAllMoviesFromLocal()
        } else {
            movieRepository.getAllMoviesFromLocal()
        }
    }*/

/*suspend fun getAllMovies(): List<Movie> = withContext(ioDispatcher) {
        val movie = movieRepository.getAllMoviesFromRemote()
        if (InternetCheck.isNetworkAvailable()) {
            if (movie.isNotEmpty()) {
                movieRepository.clearMovies()
                //movieRepository.insert(movie.map { it.movieEntityToMovieModel() })
                movie.map { movieRepository.saveAllMovies(it.movieToMovieEntity()) }
            }
            movieRepository.getAllMoviesFromLocal()
        } else {
            movieRepository.clearMovies()
            movieRepository.getAllMoviesFromLocal()
        }
    }*/

/* return networkBoundResource(
            fetchFromLocal = { movieRepository.getAllMoviesFromRoom() },  //Extrae datos de la base de datos local (Room)
            shouldFetchFromRemote = { localData -> localData == null }, //Decide si se debe realizar una solicitud de red(RETROFIT) o usar datos persistentes locales(ROOM) si están disponibles
            fetchFromRemote = { movieRepository.getAllMoviesFromRetrofit() }, //Realiza una operación de solicitud de red(RETROFIT)
            processRemoteResponse = { }, //Procesa el resultado de la respuesta de la red((RETROFIT)) antes de guardar la clase del modelo en la base de datos, como guardar ciertos valores de encabezado
            saveRemoteData = { movieRepository.insertMovies(it) }, //Guarda el resultado de la solicitud de red(RETROFIT) en la base de datos persistente local(ROOM)
            onFetchFailed = { errorBody: String?, statusCode: Int -> } //Maneja el escenario de falla de solicitud de red (respuesta  HTTP 200..300, excepciones, etc.)
        ).flowOn(ioDispatcher)*/