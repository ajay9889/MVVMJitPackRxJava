package com.anushka.tmdbclient.data.repository.datasourceimpl.artist

import com.anushka.tmdbclient.data.api.TMDBService
import com.anushka.tmdbclient.data.repository.datasource.artist.ArtistRemoteDataSource

class ArtistRemoteDataSourceImpl (private val tbService: TMDBService,
private val api_key:String): ArtistRemoteDataSource {
    override suspend fun getRemoteArtiList() = tbService.getPopularArtistList(api_key)
}