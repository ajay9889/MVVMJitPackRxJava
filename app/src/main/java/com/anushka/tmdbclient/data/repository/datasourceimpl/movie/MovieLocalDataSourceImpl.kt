package com.anushka.tmdbclient.data.repository.datasourceimpl.movie

import com.anushka.tmdbclient.data.db.MoviDao
import com.anushka.tmdbclient.data.model.movie.Movie
import com.anushka.tmdbclient.data.repository.datasource.movie.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourceImpl (private val movieDao: MoviDao): MovieLocalDataSource {
    override suspend fun getMoviewsFromDB()= movieDao.getAllMovie()
    override suspend fun saveMovieToDB(movie: List<Movie>) {
        CoroutineScope(Dispatchers.IO
        ).launch {
            movieDao.saveMovies(movie)
        }
    }

    override suspend fun cleadAll() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.deleteAllMovie()
        }
   }
}