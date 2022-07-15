package com.example.themovieapp.utils

sealed class UiState<T>() {
    class Success<T>(val data: T): UiState<T>()
    class Loading<T>: UiState<T>()
    class Error<T>(val message: T): UiState<T>()
}