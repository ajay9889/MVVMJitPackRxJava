package com.anushka.tmdbclient.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.anushka.tmdbclient.data.model.movie.Movie

@Dao
interface MoviDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movie: List<Movie>)

    @Query("delete from popular_movie")
    suspend fun deleteAllMovie()

    @Query("SELECT * FROM popular_movie")
    suspend fun getAllMovie(): List<Movie>
}