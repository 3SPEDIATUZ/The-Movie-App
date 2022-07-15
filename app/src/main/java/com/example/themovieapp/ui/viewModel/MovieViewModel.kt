package com.example.themovieapp.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.themovieapp.data.response.MovieModelResponse
import com.example.themovieapp.domain.MovieUseCase
import com.example.themovieapp.domain.model.Movie
import com.hadiyarajesh.flower.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private val movieUseCase: MovieUseCase) : ViewModel() {

    val quoteModel = MutableLiveData<Movie>()
    val isLoading = MutableLiveData<Boolean>()

    fun getMovies() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = movieUseCase()

            if (!result.isNullOrEmpty()) {
                quoteModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }
}

/* private val _dataMovie = MutableStateFlow<Resource<MovieModelResponse>>(Resource.loading(null))
    val dataMovieModel: StateFlow<Resource<MovieModelResponse>> = _dataMovie

    fun getMovies() {
        viewModelScope.launch {
            movieUseCase.getMovies()
                .catch { error ->
                    _dataMovie.value = Resource.error(error.toString(), 400)
                }.collect { movieResponse ->
                    _dataMovie.value = movieResponse
                }
        }
    }*/