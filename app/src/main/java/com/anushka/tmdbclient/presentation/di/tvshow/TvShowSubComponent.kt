package com.anushka.tmdbclient.presentation.di.tvshow

import com.anushka.tmdbclient.presentation.tv.TvShowsActivity
import dagger.Subcomponent

@TvShowScope
@Subcomponent (modules = [TvShowModule::class])
interface TvShowSubComponent {
    fun inject(tvShowsActivity: TvShowsActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create(): TvShowSubComponent
    }
}