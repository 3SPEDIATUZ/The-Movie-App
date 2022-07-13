package com.example.themovieapp.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.themovieapp.data.response.MovieResponse
import com.example.themovieapp.domain.MovieUseCase
import com.hadiyarajesh.flower.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private val movieUseCase: MovieUseCase) : ViewModel() {

    private val _dataMovie = MutableStateFlow<Resource<MovieResponse>>(Resource.loading(null))
    val dataMovie: StateFlow<Resource<MovieResponse>> = _dataMovie

    fun getMovies() {
        viewModelScope.launch {
            movieUseCase.getMovies()
                .catch { error ->
                    _dataMovie.value = Resource.error(error.toString(), 400)
                }.collect { movieResponse ->
                    withContext(Dispatchers.Main) {
                        _dataMovie.value = movieResponse
                    }
                }
        }
    }
}