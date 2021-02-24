package com.anushka.tmdbclient.data.repository.datasource.tvshow

import com.anushka.tmdbclient.data.model.tvshows.TvList
import retrofit2.Response

interface TvShowRemoteDataSource {
    suspend fun getTvShowList(): Response<TvList>

}