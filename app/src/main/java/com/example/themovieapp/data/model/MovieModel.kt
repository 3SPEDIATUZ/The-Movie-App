package com.example.themovieapp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class MovieModel(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,

    @SerializedName("original_title")
    @ColumnInfo(name = "original_title")
    val title: String,

    @SerializedName("poster_path")
    @ColumnInfo(name = "poster_path")
    val poster: String
)

