package com.example.themovieapp.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.themovieapp.data.model.MovieModel

@Entity(tableName = "movie_table")
data class MovieEntityResponse(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,

    @ColumnInfo(name = "results")
    val movieEntity: List<MovieEntity>
)
