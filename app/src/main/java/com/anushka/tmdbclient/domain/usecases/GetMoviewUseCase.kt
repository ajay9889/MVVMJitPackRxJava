package com.anushka.tmdbclient.domain.usecases

import com.anushka.tmdbclient.data.model.movie.Movie
import com.anushka.tmdbclient.domain.repository.MovieRepository

class GetMoviewUseCase (private val movieRepository: MovieRepository) {
    suspend fun execute():List<Movie>? = movieRepository.getMovie()
}