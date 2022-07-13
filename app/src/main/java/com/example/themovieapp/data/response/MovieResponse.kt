package com.example.themovieapp.data.response

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.themovieapp.data.model.MovieModel
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movie_table")
data class MovieResponse(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,

    @SerializedName("results")
    @ColumnInfo(name = "results")
    val movieModels: List<MovieModel>
)
