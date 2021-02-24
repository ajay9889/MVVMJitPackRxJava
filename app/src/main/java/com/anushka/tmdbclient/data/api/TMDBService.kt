package com.anushka.tmdbclient.data.api

import com.anushka.tmdbclient.data.model.artist.ArtistList
import com.anushka.tmdbclient.data.model.movie.MovieList
import com.anushka.tmdbclient.data.model.tvshows.TvList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {

    @GET("movie/popular") // endpoint
    suspend fun getPopularMovie(

        @Query("api_key") apikey: String

    ): Response<MovieList>

    @GET("tv/popular") // endpoint
    suspend fun getPopularTVShows(

        @Query("api_key") apikey: String

    ): Response<TvList>

    @GET("person/popular") // endpoint
    suspend fun getPopularArtistList(

        @Query("api_key") apikey: String

    ): Response<ArtistList>
}