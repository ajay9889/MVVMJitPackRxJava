package com.anushka.tmdbclient.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.anushka.tmdbclient.domain.usecases.GetMoviewUseCase
import com.anushka.tmdbclient.domain.usecases.UpdateMoviewUsecase

class MovieViewModelFactory(
    private val getMoviewUseCase: GetMoviewUseCase,
    private val updateMoviewUsecase: UpdateMoviewUsecase
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
      return MovieViewModel(getMoviewUseCase,updateMoviewUsecase) as T
    }
}