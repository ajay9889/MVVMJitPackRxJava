package com.anushka.tmdbclient.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.anushka.tmdbclient.data.model.tvshows.TVShow

@Dao
interface TvShowDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTVshow(movie: List<TVShow>)

    @Query("delete from popular_tvshow")
    suspend fun deleteAllTVshow()

    @Query("SELECT * FROM popular_movie")
    suspend fun getAllTVshow(): List<TVShow>
}