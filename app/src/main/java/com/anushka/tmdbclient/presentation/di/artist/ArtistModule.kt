package com.anushka.tmdbclient.presentation.di.artist

import com.anushka.tmdbclient.domain.usecases.GetArtistUseCase
import com.anushka.tmdbclient.domain.usecases.GetMoviewUseCase
import com.anushka.tmdbclient.domain.usecases.UpdateArtistUseCase
import com.anushka.tmdbclient.presentation.artist.ArtistViewModel
import com.anushka.tmdbclient.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {
    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory (
        getArtistUseCase: GetArtistUseCase,
        updateArtistUseCase: UpdateArtistUseCase
    ):ArtistViewModelFactory{

        return ArtistViewModelFactory(
            getArtistUseCase,
            updateArtistUseCase
        )

    }
}