package com.anushka.tmdbclient.presentation.di.core

import com.anushka.tmdbclient.domain.repository.ArtistRepository
import com.anushka.tmdbclient.domain.repository.MovieRepository
import com.anushka.tmdbclient.domain.repository.TvShowRepository
import com.anushka.tmdbclient.domain.usecases.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {
    @Singleton
    @Provides
    fun providegetMoviewUseCase(movieRepository: MovieRepository): GetMoviewUseCase{
        return GetMoviewUseCase(movieRepository)
    }
    @Singleton
    @Provides
    fun provideUpdateMoviewUseCase(movieRepository: MovieRepository): UpdateMoviewUsecase{
        return UpdateMoviewUsecase(movieRepository)
    }


    @Singleton
    @Provides
    fun provideGetTvShowUseCase(tvShowRepository: TvShowRepository): TVShowUseCase{
        return TVShowUseCase(tvShowRepository)
    }



    @Singleton
    @Provides
    fun provideUpdateTvShowUseCase(tvShowRepository: TvShowRepository): UpdateTvShowUseCase{
        return UpdateTvShowUseCase(tvShowRepository)
    }




    @Singleton
    @Provides
    fun provideGetArtistUseCase(artistRepository: ArtistRepository): GetArtistUseCase{
        return GetArtistUseCase(artistRepository)
    }



    @Singleton
    @Provides
    fun provideUpdateArtistUseCase(artistRepository: ArtistRepository): UpdateArtistUseCase{
        return UpdateArtistUseCase(artistRepository)
    }


}