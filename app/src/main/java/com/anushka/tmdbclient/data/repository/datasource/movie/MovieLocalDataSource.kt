package com.anushka.tmdbclient.data.repository.datasource.movie

import com.anushka.tmdbclient.data.model.movie.Movie

interface MovieLocalDataSource {
    suspend fun getMoviewsFromDB():List<Movie>
    suspend fun saveMovieToDB(movie:List<Movie>);
    suspend fun cleadAll()
}