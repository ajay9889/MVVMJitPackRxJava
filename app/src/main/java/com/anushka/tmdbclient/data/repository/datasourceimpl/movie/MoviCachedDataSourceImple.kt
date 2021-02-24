package com.anushka.tmdbclient.data.repository.datasourceimpl.movie

import com.anushka.tmdbclient.data.model.movie.Movie
import com.anushka.tmdbclient.data.repository.datasource.movie.MovieCachedDataSource

class MoviCachedDataSourceImple: MovieCachedDataSource {
    private var movieList =ArrayList<Movie>()
    override suspend fun getMovieFromCached(): List<Movie> {
        return movieList;
    }
    override suspend fun savedMovieCached(movies: List<Movie>) {
        movieList.clear()
        movieList.addAll(ArrayList(movies))
    }
}