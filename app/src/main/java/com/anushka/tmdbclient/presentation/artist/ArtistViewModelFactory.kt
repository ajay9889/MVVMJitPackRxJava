package com.anushka.tmdbclient.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.anushka.tmdbclient.domain.usecases.GetArtistUseCase
import com.anushka.tmdbclient.domain.usecases.TVShowUseCase
import com.anushka.tmdbclient.domain.usecases.UpdateArtistUseCase
import com.anushka.tmdbclient.domain.usecases.UpdateTvShowUseCase

class ArtistViewModelFactory (
    private val artistUseCase: GetArtistUseCase,
    private val updateArtistUseCase: UpdateArtistUseCase
        ): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
       return ArtistViewModel(artistUseCase,updateArtistUseCase )as T
    }
}