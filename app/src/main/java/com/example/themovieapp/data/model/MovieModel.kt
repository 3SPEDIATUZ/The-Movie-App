package com.example.themovieapp.data.model

import com.google.gson.annotations.SerializedName

data class MovieModel(
    @SerializedName("original_title") val title: String,
    @SerializedName("poster_path") val poster: String
)


