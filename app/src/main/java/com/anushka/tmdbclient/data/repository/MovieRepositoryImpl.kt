package com.anushka.tmdbclient.data.repository

import com.anushka.tmdbclient.data.model.movie.Movie
import com.anushka.tmdbclient.data.model.movie.MovieList
import com.anushka.tmdbclient.data.repository.datasource.movie.MovieCachedDataSource
import com.anushka.tmdbclient.data.repository.datasource.movie.MovieLocalDataSource
import com.anushka.tmdbclient.data.repository.datasource.movie.MovieRemoteDataSource
import com.anushka.tmdbclient.domain.repository.MovieRepository
import retrofit2.Response

class MovieRepositoryImpl(private val movieRemoteDataSource: MovieRemoteDataSource,
                          private val movieLocalDataSource: MovieLocalDataSource,
                          private val movieCachedDataSource: MovieCachedDataSource
): MovieRepository {
    override suspend fun getMovie(): List<Movie>? {
       return getMoviFromDB()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies: List<Movie> = getMoviewFromApi();
        movieLocalDataSource.cleadAll()
        movieLocalDataSource.saveMovieToDB(newListOfMovies)
        movieCachedDataSource.savedMovieCached(newListOfMovies)
        return getMoviFromDB()
    }

    suspend fun getMoviewFromApi(): List<Movie> {

        var  movieList: List<Movie> = arrayListOf();
        try{

            val response: Response<MovieList> = movieRemoteDataSource.getMovie()
            response.body()?.let {
               movieList=it.results
            }
        }catch (e:Exception){
            e.printStackTrace()
        }
        return movieList;
    }

    suspend fun getMoviFromDB (): List<Movie>{
        var  movieList: List<Movie> = arrayListOf();
        try{
            movieList = movieLocalDataSource.getMoviewsFromDB()
        }catch (e:java.lang.Exception)
        {
            e.printStackTrace()
        }
        if(movieList.size>0){
            return movieList;
        }else{
            movieList = getMoviewFromApi()
            movieLocalDataSource.saveMovieToDB(movieList);
        }
        return movieList
    }

    suspend fun getCachedData() : List<Movie>{

        var  movieList: List<Movie> = arrayListOf();
        try{
            movieList = movieCachedDataSource.getMovieFromCached()
        }catch (e:java.lang.Exception)
        {
            e.printStackTrace()
        }
        if(movieList.size>0){
            return movieList;
        }else{
            movieList = getMoviFromDB()
            movieCachedDataSource.savedMovieCached(movieList)
        }
        return movieList
    }

}