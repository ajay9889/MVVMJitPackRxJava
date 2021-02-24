package com.anushka.tmdbclient.presentation.tv

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.anushka.tmdbclient.domain.usecases.TVShowUseCase
import com.anushka.tmdbclient.domain.usecases.UpdateTvShowUseCase

class TvShowViewModelFactory (
    private val useCase: TVShowUseCase,
    private val updateTvShowUseCase: UpdateTvShowUseCase
        ): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
       return TvShowViewModel(useCase,updateTvShowUseCase )as T
    }
}