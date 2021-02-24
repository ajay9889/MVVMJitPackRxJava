package com.anushka.tmdbclient.data.repository

import com.anushka.tmdbclient.data.model.artist.Artist
import com.anushka.tmdbclient.data.repository.datasource.artist.ArtistCachedDataSource
import com.anushka.tmdbclient.data.repository.datasource.artist.ArtistLocalDataSource
import com.anushka.tmdbclient.data.repository.datasource.artist.ArtistRemoteDataSource
import com.anushka.tmdbclient.domain.repository.ArtistRepository
import java.lang.Exception

class ArtistRepositoryImpl (
   private val artistRemoteDataSource: ArtistRemoteDataSource,
   private val  artistLocalDataSource: ArtistLocalDataSource,
   private val  artistCachedDataSource: ArtistCachedDataSource
    ) : ArtistRepository {

    override suspend fun getArtist(): List<Artist>? {

        return  getArtistListFromLocalDB();
    }

    override suspend fun updateArtist(): List<Artist>? {
        var artistList: List<Artist> =getArtistListFromAPI()
        artistLocalDataSource.clearAllArtist()
        artistLocalDataSource.savedInDBArtiList(artistList)
        artistCachedDataSource.savedinCachedArtiList(artistList)
        return artistList
    }

    suspend fun getArtistListFromAPI(): List<Artist> {
        var artistList: List<Artist> = arrayListOf();
        try{
            val response = artistRemoteDataSource.getRemoteArtiList()
            response.body().let {
                artistList=it?.results!!
            }

        }catch (e: Exception){e.printStackTrace()}

        return artistList;
    }

    suspend fun getArtistListFromLocalDB(): List<Artist>
    {
        var tArtist: List<Artist> = arrayListOf();
        try{

            tArtist=artistLocalDataSource.getArtiList()
        }catch (e: Exception){e.printStackTrace()}

        if(tArtist.size>0){
            return tArtist
        }else{
            tArtist=getArtistListFromAPI()
            artistLocalDataSource.savedInDBArtiList(tArtist);
        }
        return tArtist;

    }
    suspend fun getTvShowsFromCached(): List<Artist>
    {
        var tvShowList: List<Artist> = arrayListOf();
        try{
            tvShowList=artistCachedDataSource.getCachedArtistList();
        }catch (e: Exception){e.printStackTrace()}

        if(tvShowList.size>0){
            return tvShowList
        }else{
            tvShowList=getArtistListFromLocalDB()
            artistCachedDataSource.savedinCachedArtiList(tvShowList);
        }
        return tvShowList;

    }


}