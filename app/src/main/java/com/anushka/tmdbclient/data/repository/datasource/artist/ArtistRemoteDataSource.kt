package com.anushka.tmdbclient.data.repository.datasource.artist

import com.anushka.tmdbclient.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getRemoteArtiList():Response<ArtistList>
}