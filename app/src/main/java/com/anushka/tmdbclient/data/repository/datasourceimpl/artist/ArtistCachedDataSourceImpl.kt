package com.anushka.tmdbclient.data.repository.datasourceimpl.artist

import com.anushka.tmdbclient.data.model.artist.Artist
import com.anushka.tmdbclient.data.repository.datasource.artist.ArtistCachedDataSource

class ArtistCachedDataSourceImpl : ArtistCachedDataSource {
    private var artistList =ArrayList<Artist>()
    override suspend fun getCachedArtistList(): List<Artist> {
       return artistList
    }

    override suspend fun savedinCachedArtiList(mArtiList: List<Artist>) {
        artistList.clear()
        artistList.addAll(ArrayList(mArtiList))
    }
}