package com.anushka.tmdbclient.data.model.tvshows

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "popular_tvshow")

data class TVShow(
    @PrimaryKey
    val id: Int,
    val backdrop_path: String?,
    val first_air_date: String?,
    val name: String?,
    val original_language: String?,
    val original_name: String?,
   val popularity: Double?,
    val poster_path: String?,
)