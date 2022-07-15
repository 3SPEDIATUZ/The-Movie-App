package com.example.themovieapp.data.response

import androidx.room.Entity
import com.example.themovieapp.data.model.MovieModel
import com.google.gson.annotations.SerializedName

@Entity
data class MovieModelResponse(
    @SerializedName("results") val movieModels: List<MovieModel>
)
