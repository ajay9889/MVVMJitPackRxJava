package com.anushka.tmdbclient.presentation.di.movie

import com.anushka.tmdbclient.domain.usecases.GetMoviewUseCase
import com.anushka.tmdbclient.domain.usecases.UpdateMoviewUsecase
import com.anushka.tmdbclient.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMoviewViewModelFactory(getMoviewUseCase: GetMoviewUseCase,
    updateMoviewUsecase: UpdateMoviewUsecase):MovieViewModelFactory{

        return MovieViewModelFactory(
            getMoviewUseCase,
            updateMoviewUsecase
        )
    }
}