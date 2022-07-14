package com.example.themovieapp.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.themovieapp.data.model.MovieResponse
import com.example.themovieapp.data.repository.MovieRepository
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onFailure
import com.skydoves.sandwich.onSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private val movieRepository: MovieRepository) : ViewModel() {
    //Encasulamiento
    private val _isSuccessMoviePopular = MutableLiveData<MovieResponse>()
    val isSuccessMoviePopular: LiveData<MovieResponse>
        get() = _isSuccessMoviePopular

    private val _isSuccessMovieUpcoming = MutableLiveData<MovieResponse>()
    val isSuccessMovieUpcoming: LiveData<MovieResponse>
        get() = _isSuccessMovieUpcoming

    private val _isSuccessMovieTopRated = MutableLiveData<MovieResponse>()
    val isSuccessMovieTopRated: LiveData<MovieResponse>
        get() = _isSuccessMovieTopRated

    private val _error = MutableLiveData<String>()
    val error: LiveData<String>
        get() = _error

    //Se suscribe
    fun getMoviePopular() {
        viewModelScope.launch {
            movieRepository.getMoviesPopular()
                .onSuccess {
                    _isSuccessMoviePopular.postValue(response.body())
                }.onError {
                    _error.postValue(response.errorBody()?.string())
                }.onFailure {

                }
        }
    }

    fun getMovieUpcoming() {
        viewModelScope.launch {
            movieRepository.getMoviesUpcoming()
                .onSuccess {
                    _isSuccessMovieUpcoming.postValue(response.body())
                }.onError {
                    _error.postValue(response.errorBody()?.string())
                }.onFailure {

                }
        }
    }

    fun getMovieTopRated() {
        viewModelScope.launch {
            movieRepository.getMoviesTop()
                .onSuccess {
                    _isSuccessMovieTopRated.postValue(response.body())
                }.onError {
                    _error.postValue(response.errorBody()?.string())
                }.onFailure {

                }
        }
    }
}