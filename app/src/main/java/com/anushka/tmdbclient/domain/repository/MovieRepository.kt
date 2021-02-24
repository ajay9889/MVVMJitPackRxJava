package com.anushka.tmdbclient.domain.repository

import com.anushka.tmdbclient.data.model.movie.Movie

interface MovieRepository {
    suspend fun getMovie():List<Movie>?
    suspend fun updateMovies(): List<Movie>?
}