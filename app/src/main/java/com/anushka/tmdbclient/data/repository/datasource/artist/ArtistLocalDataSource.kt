package com.anushka.tmdbclient.data.repository.datasource.artist

import com.anushka.tmdbclient.data.model.artist.Artist

interface ArtistLocalDataSource {
    suspend fun getArtiList(): List<Artist>
    suspend fun savedInDBArtiList(mArtilist: List<Artist>)
    suspend fun clearAllArtist();
}