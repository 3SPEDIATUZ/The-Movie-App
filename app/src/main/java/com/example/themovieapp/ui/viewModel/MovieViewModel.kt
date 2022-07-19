package com.example.themovieapp.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.themovieapp.data.remote.model.MovieResponse
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
    private val _successMoviePopular = MutableLiveData<MovieResponse>()
    val successMoviePopular: LiveData<MovieResponse>
        get() = _successMoviePopular

    private val _successMovieUpcoming = MutableLiveData<MovieResponse>()
    val successMovieUpcoming: LiveData<MovieResponse>
        get() = _successMovieUpcoming

    private val _successMovieTopRated = MutableLiveData<MovieResponse>()
    val successMovieTopRated: LiveData<MovieResponse>
        get() = _successMovieTopRated

    private val _error = MutableLiveData<String>()
    val error: LiveData<String>
        get() = _error

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    init {
        _isLoading.value = true
    }

    //Se suscribe
    fun getMoviePopular() {
        viewModelScope.launch {
            movieRepository.getMoviesPopular()
                .onSuccess {
                    _isLoading.value = false
                    _successMoviePopular.postValue(response.body())
                }.onError {
                    _isLoading.value = false
                    _error.postValue(response.errorBody()?.string())
                }.onFailure {
                    _isLoading.value = false
                }
        }
    }

    fun getMovieUpcoming() {
        viewModelScope.launch {
            movieRepository.getMoviesUpcoming()
                .onSuccess {
                    _isLoading.value = false
                    _successMovieUpcoming.postValue(response.body())
                }.onError {
                    _isLoading.value = false
                    _error.postValue(response.errorBody()?.string())
                }.onFailure {
                    _isLoading.value = false
                }
        }
    }

    fun getMovieTopRated() {
        viewModelScope.launch {
            movieRepository.getMoviesTop()
                .onSuccess {
                    _isLoading.value = false
                    _successMovieTopRated.postValue(response.body())
                }.onError {
                    _isLoading.value = false
                    _error.postValue(response.errorBody()?.string())
                }.onFailure {
                    _isLoading.value = false
                }
        }
    }
}