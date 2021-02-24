package com.anushka.tmdbclient.presentation

import android.app.Application
import com.anushka.tmdbclient.BuildConfig
import com.anushka.tmdbclient.presentation.di.Injector
import com.anushka.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.anushka.tmdbclient.presentation.di.core.*
import com.anushka.tmdbclient.presentation.di.movie.MovieSubComponent
import com.anushka.tmdbclient.presentation.di.tvshow.TvShowSubComponent

class App : Application() , Injector {
    private lateinit var appComponent: AppCompanant;

    override fun onCreate() {
        super.onCreate()
//        appComponent=App

        appComponent =   DaggerAppCompanant.
        builder().
        appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()



    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.moviewSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }

    override fun createArtiSubComponent(): ArtistSubComponent {
        return appComponent.artiSubCompoenent().create()
    }


}