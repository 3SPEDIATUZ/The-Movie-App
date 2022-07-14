package com.example.themovieapp.data.dto.mapper

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class MovieDTO(

@PrimaryKey(autoGenerate = true)
@ColumnInfo(name = "id")
val id: Int = 0,

@SerializedName("original_title")
@ColumnInfo(name = "original_title")
val title: String,

@SerializedName("poster_path")
@ColumnInfo(name = "poster_path")
val poster: String)
