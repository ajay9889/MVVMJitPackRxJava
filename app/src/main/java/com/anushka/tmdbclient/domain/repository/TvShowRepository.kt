package com.anushka.tmdbclient.domain.repository

import com.anushka.tmdbclient.data.model.tvshows.TVShow

interface TvShowRepository {
    suspend fun getTVShows():List<TVShow>?
    suspend fun updateTVShows():List<TVShow>?
}