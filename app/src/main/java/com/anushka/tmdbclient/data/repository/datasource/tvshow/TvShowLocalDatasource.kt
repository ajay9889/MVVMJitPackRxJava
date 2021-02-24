package com.anushka.tmdbclient.data.repository.datasource.tvshow

import com.anushka.tmdbclient.data.model.tvshows.TVShow
import retrofit2.Response

interface TvShowLocalDatasource {
    suspend fun getTVShowList(): List<TVShow>
    suspend fun saveTVShowList(tvList: List<TVShow>)
    suspend fun clearAllTvShows();
}