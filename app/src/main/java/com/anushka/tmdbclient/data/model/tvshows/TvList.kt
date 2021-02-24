package com.anushka.tmdbclient.data.model.tvshows

import androidx.room.Entity

data class TvList(
    val page: Int?,
    val TVShows: List<TVShow>,
    val total_pages: Int?,
    val total_results: Int?
)