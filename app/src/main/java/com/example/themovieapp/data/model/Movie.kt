package com.example.themovieapp.data.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class Movie(
    @SerializedName("backdrop_path") val background: String,
    @SerializedName("id") val identification: Int,
    @SerializedName("original_language") val language: String,
    @SerializedName("original_title") val originalTitle: String,
    @SerializedName("overview") val description: String,
    @SerializedName("popularity") val popularity: Float,
    @SerializedName("poster_path") val poster: String,
    @SerializedName("release_date") val date: String,
    @SerializedName("title") val title: String,
    @SerializedName("video")  val video: Boolean,
    @SerializedName("vote_average") val voteAverage: Float,
    @SerializedName("vote_count") val voteCount: Int,
    @SerializedName("adult") val adult: Boolean

)

