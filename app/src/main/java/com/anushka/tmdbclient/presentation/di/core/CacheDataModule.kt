package com.anushka.tmdbclient.presentation.di.core

import com.anushka.tmdbclient.data.repository.datasource.artist.ArtistCachedDataSource
import com.anushka.tmdbclient.data.repository.datasource.movie.MovieCachedDataSource
import com.anushka.tmdbclient.data.repository.datasource.tvshow.TvShowCachedDataSource
import com.anushka.tmdbclient.data.repository.datasourceimpl.artist.ArtistCachedDataSourceImpl
import com.anushka.tmdbclient.data.repository.datasourceimpl.movie.MoviCachedDataSourceImple
import com.anushka.tmdbclient.data.repository.datasourceimpl.tvshow.TvShowCachedDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provoidMoviewCachedDataSource(): MovieCachedDataSource{
        return MoviCachedDataSourceImple()
    }


    @Singleton
    @Provides
    fun provoidTVCachedDataSource(): TvShowCachedDataSource{
        return TvShowCachedDataSourceImpl()
    }


    @Singleton
    @Provides
    fun provoidArtistCachedDataSource(): ArtistCachedDataSource{
        return ArtistCachedDataSourceImpl()
    }
}