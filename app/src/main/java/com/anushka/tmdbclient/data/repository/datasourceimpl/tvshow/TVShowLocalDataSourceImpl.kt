package com.anushka.tmdbclient.data.repository.datasourceimpl.tvshow

import com.anushka.tmdbclient.data.db.TvShowDao
import com.anushka.tmdbclient.data.model.tvshows.TVShow
import com.anushka.tmdbclient.data.repository.datasource.tvshow.TvShowLocalDatasource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TVShowLocalDataSourceImpl(private val tvshowDao: TvShowDao): TvShowLocalDatasource {
    override suspend fun getTVShowList()=tvshowDao.getAllTVshow()
    override suspend fun saveTVShowList(tvList: List<TVShow>) {

        CoroutineScope(Dispatchers.IO).launch {
            tvshowDao.saveTVshow(tvList)
        }
    }

    override suspend fun clearAllTvShows() {
        CoroutineScope(Dispatchers.IO).launch {
            tvshowDao.deleteAllTVshow()
        }
    }
}