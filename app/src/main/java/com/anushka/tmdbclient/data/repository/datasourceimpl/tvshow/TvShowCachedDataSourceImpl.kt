package com.anushka.tmdbclient.data.repository.datasourceimpl.tvshow

import com.anushka.tmdbclient.data.model.tvshows.TVShow
import com.anushka.tmdbclient.data.repository.datasource.tvshow.TvShowCachedDataSource

class TvShowCachedDataSourceImpl: TvShowCachedDataSource {

   private var tvarrayShow= ArrayList<TVShow>();

    override suspend fun getTVshowList(): List<TVShow> {
        return tvarrayShow;
    }

    override suspend fun savedTvShows(tvShow: List<TVShow>) {
        tvarrayShow.clear()
        tvarrayShow.addAll(ArrayList(tvShow))
    }
}