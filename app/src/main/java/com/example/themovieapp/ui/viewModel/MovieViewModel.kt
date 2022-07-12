package com.example.themovieapp.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.themovieapp.data.model.MovieReponse
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
    private val _isSuccess = MutableLiveData<MovieReponse>()
    val isSuccess: LiveData<MovieReponse>
        get() = _isSuccess

    private val _isError = MutableLiveData<String>()
    val isError: MutableLiveData<String>
        get() = _isError

     fun getMovie(){
        viewModelScope.launch {
            movieRepository.getMovies().onSuccess {
                _isSuccess.postValue(response.body())
            }.onError {
                _isError.postValue(response.errorBody()?.string())
            }.onFailure {

            }
        }
    }
}