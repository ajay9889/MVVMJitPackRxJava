package com.anushka.tmdbclient.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.anushka.tmdbclient.data.model.artist.Artist
import com.anushka.tmdbclient.data.model.movie.Movie
import com.anushka.tmdbclient.data.model.tvshows.TVShow

@Database (entities = [Movie::class, TVShow::class, Artist::class],
version = 1,
exportSchema = false)
abstract class TMDBDatabase: RoomDatabase() {
    abstract fun moviewDao(): MoviDao;
    abstract fun tvShowDao(): TvShowDao
    abstract fun artistDao(): ArtistDao



}