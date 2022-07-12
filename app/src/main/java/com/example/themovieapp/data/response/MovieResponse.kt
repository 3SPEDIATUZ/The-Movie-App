package com.example.themovieapp.data.response

import com.example.themovieapp.data.model.MovieModel
import com.google.gson.annotations.SerializedName

data class MovieResponse(@SerializedName("results") val movieModels: List<MovieModel>)
