package com.example.themovieapp.data.remote.response

import com.example.themovieapp.data.remote.model.MovieModel
import com.google.gson.annotations.SerializedName

data class MovieModelResponse(
    @SerializedName("results") val movieModels: List<MovieModel>
)
