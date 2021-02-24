package com.anushka.tmdbclient.data.repository.datasource.movie

import com.anushka.tmdbclient.data.model.movie.Movie

interface MovieCachedDataSource {
    suspend fun getMovieFromCached():List<Movie>
    suspend fun savedMovieCached(movies: List<Movie>);

}