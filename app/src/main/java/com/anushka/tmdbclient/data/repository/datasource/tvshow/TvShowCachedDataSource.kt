package com.anushka.tmdbclient.data.repository.datasource.tvshow

import com.anushka.tmdbclient.data.model.tvshows.TVShow

interface TvShowCachedDataSource {
    suspend fun getTVshowList():List<TVShow>
    suspend fun savedTvShows(tvShow: List<TVShow>)
}