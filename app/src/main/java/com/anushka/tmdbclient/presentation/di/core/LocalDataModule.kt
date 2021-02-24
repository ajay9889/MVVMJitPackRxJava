package com.anushka.tmdbclient.presentation.di.core

import com.anushka.tmdbclient.data.db.ArtistDao
import com.anushka.tmdbclient.data.db.MoviDao
import com.anushka.tmdbclient.data.db.TvShowDao
import com.anushka.tmdbclient.data.repository.datasource.artist.ArtistLocalDataSource
import com.anushka.tmdbclient.data.repository.datasource.movie.MovieLocalDataSource
import com.anushka.tmdbclient.data.repository.datasource.tvshow.TvShowLocalDatasource
import com.anushka.tmdbclient.data.repository.datasourceimpl.artist.ArtistLocalDataSourceImpl
import com.anushka.tmdbclient.data.repository.datasourceimpl.movie.MovieLocalDataSourceImpl
import com.anushka.tmdbclient.data.repository.datasourceimpl.tvshow.TVShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule  {

    @Singleton
    @Provides
    fun provideLocalMovieDataSource(moviDao: MoviDao): MovieLocalDataSource{
       return MovieLocalDataSourceImpl(moviDao)
    }
    @Singleton
    @Provides
    fun provideLocalTvDataSource(tvShowDao: TvShowDao): TvShowLocalDatasource{
        return TVShowLocalDataSourceImpl(tvShowDao)
    }

    @Singleton
    @Provides
    fun provideLocalArtiedDataSource(artistDao: ArtistDao): ArtistLocalDataSource{
        return ArtistLocalDataSourceImpl(artistDao)
    }



}