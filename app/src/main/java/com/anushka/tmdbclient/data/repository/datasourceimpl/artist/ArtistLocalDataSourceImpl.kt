package com.anushka.tmdbclient.data.repository.datasourceimpl.artist

import com.anushka.tmdbclient.data.db.ArtistDao
import com.anushka.tmdbclient.data.model.artist.Artist
import com.anushka.tmdbclient.data.repository.datasource.artist.ArtistLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl (
    private val artiDao: ArtistDao
        ): ArtistLocalDataSource {
    override suspend fun getArtiList(): List<Artist> {
      return artiDao.getAllArtist()
    }

    override suspend fun savedInDBArtiList(mArtilist: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artiDao.saveArtist(mArtilist)
        }
    }

    override suspend fun clearAllArtist() {
        CoroutineScope(Dispatchers.IO).launch {
            artiDao.deleteAllArtist()
        }

    }
}