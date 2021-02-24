package com.anushka.tmdbclient.presentation.di.tvshow

import com.anushka.tmdbclient.domain.usecases.GetMoviewUseCase
import com.anushka.tmdbclient.domain.usecases.TVShowUseCase
import com.anushka.tmdbclient.domain.usecases.UpdateMoviewUsecase
import com.anushka.tmdbclient.domain.usecases.UpdateTvShowUseCase
import com.anushka.tmdbclient.presentation.movie.MovieViewModelFactory
import com.anushka.tmdbclient.presentation.tv.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideMoviewViewModelFactory(tvShowUseCase: TVShowUseCase,
    updateTvShowUseCase: UpdateTvShowUseCase):TvShowViewModelFactory{

        return TvShowViewModelFactory(
            tvShowUseCase,
            updateTvShowUseCase
        )
    }
}