package com.anushka.tmdbclient.domain.usecases

import com.anushka.tmdbclient.data.model.tvshows.TVShow
import com.anushka.tmdbclient.domain.repository.TvShowRepository

class TVShowUseCase (private val tvShowRepository: TvShowRepository) {
    suspend fun execute(): List<TVShow>? = tvShowRepository.getTVShows()
}