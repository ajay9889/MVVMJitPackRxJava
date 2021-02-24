package com.anushka.tmdbclient.data.repository.datasourceimpl.tvshow

import com.anushka.tmdbclient.data.api.TMDBService
import com.anushka.tmdbclient.data.repository.datasource.tvshow.TvShowRemoteDataSource

class TvShowsRemoteDataSourceImple (private val tmbdService: TMDBService,private val api_key:String):
    TvShowRemoteDataSource {
    override suspend fun getTvShowList() = tmbdService.getPopularTVShows(api_key)
}