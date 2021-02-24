
package com.anushka.tmdbclient.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.anushka.tmdbclient.domain.usecases.GetArtistUseCase
import com.anushka.tmdbclient.domain.usecases.TVShowUseCase
import com.anushka.tmdbclient.domain.usecases.UpdateArtistUseCase
import com.anushka.tmdbclient.domain.usecases.UpdateTvShowUseCase

class ArtistViewModel(
    private val getArtistUseCase: GetArtistUseCase,
    private val updateArtistUseCase: UpdateArtistUseCase

): ViewModel() {
    fun getArtistShowsList() = liveData {
        val artistList =getArtistUseCase.execute()
        emit(artistList)
    }


    fun updateArtistShowsList() = liveData {
        val artistList =updateArtistUseCase.execute()
        emit(artistList)
    }
}