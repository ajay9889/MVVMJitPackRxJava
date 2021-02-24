package com.anushka.tmdbclient.data.repository.datasource.movie

import com.anushka.tmdbclient.data.model.movie.Movie
import com.anushka.tmdbclient.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovie(): Response<MovieList>
}