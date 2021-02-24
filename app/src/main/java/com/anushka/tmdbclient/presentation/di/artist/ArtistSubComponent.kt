package com.anushka.tmdbclient.presentation.di.artist

import com.anushka.tmdbclient.presentation.artist.ArtistActivity
import dagger.Subcomponent

@ArtistScope
@Subcomponent (modules = [ArtistModule::class])
interface ArtistSubComponent  {


    fun inject (artistActivity: ArtistActivity)


    // we must define subcomponent factory inside subcompanent so the App level Artist componenet how to interact
    // to know the how to create subcompanet

    @Subcomponent.Factory
    interface Factory{
        fun create(): ArtistSubComponent;
    }
}