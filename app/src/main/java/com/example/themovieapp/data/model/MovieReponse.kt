package com.example.themovieapp.data.model

import com.google.gson.annotations.SerializedName

data class MovieReponse(
    @SerializedName("results") val response: List<Movie>
)