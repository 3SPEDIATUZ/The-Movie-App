package com.example.themovieapp.iu.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.themovieapp.data.model.Movie
import com.example.themovieapp.data.repository.MovieRepository
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onFailure
import com.skydoves.sandwich.onSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel //es para reconocer el hilt
class MainViewModel @Inject constructor(private val movieRepository: MovieRepository) :
    ViewModel() {
    //Encasulamiento
    private val _isSuccess = MutableLiveData<Movie>()
    val isSuccess:LiveData<Movie>
    get() = _isSuccess

    fun getMovie() {
        viewModelScope.launch {
            movieRepository.getMovies()
                .onSuccess {
                    //suscribiendonos a liveData
                    _isSuccess.postValue(data.)
                }.onError {
                    _isSuccess.postValue(false)
                }.onFailure {
                    _isSuccess.postValue(true)
                }
        }
    }
}