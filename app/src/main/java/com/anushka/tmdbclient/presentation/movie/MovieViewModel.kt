package com.anushka.tmdbclient.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.anushka.tmdbclient.domain.usecases.GetMoviewUseCase
import com.anushka.tmdbclient.domain.usecases.UpdateMoviewUsecase
import kotlinx.coroutines.Dispatchers

class MovieViewModel (
    private val getMoviewUseCase: GetMoviewUseCase,
    private val updateMoviewUsecase: UpdateMoviewUsecase
        ): ViewModel(){

    fun getMovie()= liveData {
        val movieList = getMoviewUseCase.execute()
        emit(movieList)
    }

    fun updateMovie() = liveData {
        val movieList = updateMoviewUsecase.execute()
        emit(movieList)
    }

}