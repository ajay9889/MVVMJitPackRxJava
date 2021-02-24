package com.anushka.tmdbclient.data.model.movie

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "popular_movie")
data class Movie(
    @PrimaryKey
    val id: Int,
    val overview: String?,
    val poster_path: String?,
    val release_date: String?,
    val title: String?,
)
