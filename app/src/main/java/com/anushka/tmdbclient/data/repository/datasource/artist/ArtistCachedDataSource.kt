package com.anushka.tmdbclient.data.repository.datasource.artist

import com.anushka.tmdbclient.data.model.artist.Artist

interface ArtistCachedDataSource {

    suspend fun getCachedArtistList(): List<Artist>
    suspend fun savedinCachedArtiList(mArtiList: List<Artist>)
}