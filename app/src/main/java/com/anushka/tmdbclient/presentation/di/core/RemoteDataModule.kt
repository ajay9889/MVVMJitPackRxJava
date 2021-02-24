package com.anushka.tmdbclient.presentation.di.core

import com.anushka.tmdbclient.data.api.TMDBService
import com.anushka.tmdbclient.data.db.TMDBDatabase
import com.anushka.tmdbclient.data.repository.datasource.artist.ArtistRemoteDataSource
import com.anushka.tmdbclient.data.repository.datasource.movie.MovieRemoteDataSource
import com.anushka.tmdbclient.data.repository.datasource.tvshow.TvShowCachedDataSource
import com.anushka.tmdbclient.data.repository.datasource.tvshow.TvShowRemoteDataSource
import com.anushka.tmdbclient.data.repository.datasourceimpl.artist.ArtistRemoteDataSourceImpl
import com.anushka.tmdbclient.data.repository.datasourceimpl.movie.MovieRemoteDataSourceImpl
import com.anushka.tmdbclient.data.repository.datasourceimpl.tvshow.TVShowLocalDataSourceImpl
import com.anushka.tmdbclient.data.repository.datasourceimpl.tvshow.TvShowsRemoteDataSourceImple
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule (private val api_key:String){

    @Singleton
    @Provides
    fun provideRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource{
        return MovieRemoteDataSourceImpl(
            tmdbService,api_key
        )
    };
    @Singleton
    @Provides
    fun provideRemoteTVDataSource(tmdbService: TMDBService): TvShowRemoteDataSource{
        return TvShowsRemoteDataSourceImple(
            tmdbService,api_key
        )
    };
    @Singleton
    @Provides
    fun provideRemoteArtistDataSource(tmdbService: TMDBService): ArtistRemoteDataSource{
        return ArtistRemoteDataSourceImpl(
            tmdbService,api_key
        )
    };
}
