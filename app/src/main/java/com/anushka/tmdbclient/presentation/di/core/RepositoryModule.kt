package com.anushka.tmdbclient.presentation.di.core

import com.anushka.tmdbclient.data.repository.ArtistRepositoryImpl
import com.anushka.tmdbclient.data.repository.MovieRepositoryImpl
import com.anushka.tmdbclient.data.repository.TvShowRepositoryImpl
import com.anushka.tmdbclient.data.repository.datasource.artist.ArtistCachedDataSource
import com.anushka.tmdbclient.data.repository.datasource.artist.ArtistLocalDataSource
import com.anushka.tmdbclient.data.repository.datasource.artist.ArtistRemoteDataSource
import com.anushka.tmdbclient.data.repository.datasource.movie.MovieCachedDataSource
import com.anushka.tmdbclient.data.repository.datasource.movie.MovieLocalDataSource
import com.anushka.tmdbclient.data.repository.datasource.movie.MovieRemoteDataSource
import com.anushka.tmdbclient.data.repository.datasource.tvshow.TvShowCachedDataSource
import com.anushka.tmdbclient.data.repository.datasource.tvshow.TvShowLocalDatasource
import com.anushka.tmdbclient.data.repository.datasource.tvshow.TvShowRemoteDataSource
import com.anushka.tmdbclient.domain.repository.ArtistRepository
import com.anushka.tmdbclient.domain.repository.MovieRepository
import com.anushka.tmdbclient.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMoviRepository(

        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCachedDataSource: MovieCachedDataSource


    ): MovieRepository {
        return MovieRepositoryImpl(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCachedDataSource
        )
    }



    @Singleton
    @Provides
    fun provideTvRepository(

       tvShowRemoteDataSource: TvShowRemoteDataSource,
       tvShowLocalDatasource: TvShowLocalDatasource,
       tvShowCachedDataSource: TvShowCachedDataSource


    ): TvShowRepository{
        return TvShowRepositoryImpl(
            tvShowRemoteDataSource,
            tvShowLocalDatasource,
            tvShowCachedDataSource
        )
    }



    @Singleton
    @Provides
    fun provideArtistRepository(

        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCachedDataSource: ArtistCachedDataSource
     ): ArtistRepository{
        return ArtistRepositoryImpl(
            artistRemoteDataSource,
            artistLocalDataSource,
            artistCachedDataSource
        )
    }


}