package com.example.themovieapp.data.model

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("results") val response: List<Movie>
)