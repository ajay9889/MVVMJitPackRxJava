package com.anushka.tmdbclient.domain.usecases

import com.anushka.tmdbclient.data.model.movie.Movie
import com.anushka.tmdbclient.domain.repository.MovieRepository

class UpdateMoviewUsecase (private val repository: MovieRepository) {
    suspend fun execute():List<Movie>? = repository.updateMovies()
}