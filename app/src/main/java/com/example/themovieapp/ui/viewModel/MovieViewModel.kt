package com.example.themovieapp.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.themovieapp.data.response.MovieResponse
import com.example.themovieapp.data.repository.MovieRepository
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onFailure
import com.skydoves.sandwich.onSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private val movieRepository: MovieRepository) :
    ViewModel() {

    private val _dataMovie = MutableLiveData<MovieResponse>()
    val dataMovie: LiveData<MovieResponse>
        get() = _dataMovie

    fun getMovie() {
        viewModelScope.launch {
            movieRepository.getMovies()
                .onSuccess {
                    _dataMovie.postValue(response.body())
                }.onError {

                }.onFailure {

                }
        }
    }
}