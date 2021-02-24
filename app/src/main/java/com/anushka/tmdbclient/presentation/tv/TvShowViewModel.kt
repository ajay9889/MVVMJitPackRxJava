package com.anushka.tmdbclient.presentation.tv

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.anushka.tmdbclient.domain.usecases.TVShowUseCase
import com.anushka.tmdbclient.domain.usecases.UpdateTvShowUseCase

class TvShowViewModel(
    private val getTVShowUseCase: TVShowUseCase,
    private val updateTVShowUseCase: UpdateTvShowUseCase

): ViewModel() {
    fun getTvShowsList() = liveData {
        val tvList =getTVShowUseCase.execute()
        emit(tvList)
    }


    fun updateTvShowsList() = liveData {
        val tvList =updateTVShowUseCase.execute()
        emit(tvList)
    }
}