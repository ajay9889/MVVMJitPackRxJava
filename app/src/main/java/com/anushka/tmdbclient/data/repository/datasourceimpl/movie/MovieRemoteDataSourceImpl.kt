package com.anushka.tmdbclient.data.repository.datasourceimpl.movie

import com.anushka.tmdbclient.data.api.TMDBService
import com.anushka.tmdbclient.data.repository.datasource.movie.MovieRemoteDataSource

class MovieRemoteDataSourceImpl (private val tmdbService: TMDBService , val api_key: String):
    MovieRemoteDataSource {
    override suspend fun getMovie()=tmdbService.getPopularMovie(api_key)
}