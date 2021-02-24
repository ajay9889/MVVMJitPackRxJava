package com.anushka.tmdbclient.data.repository
import com.anushka.tmdbclient.data.model.tvshows.TVShow
import com.anushka.tmdbclient.data.repository.datasource.tvshow.TvShowCachedDataSource
import com.anushka.tmdbclient.data.repository.datasource.tvshow.TvShowLocalDatasource
import com.anushka.tmdbclient.data.repository.datasource.tvshow.TvShowRemoteDataSource
import com.anushka.tmdbclient.domain.repository.TvShowRepository
import java.lang.Exception

class TvShowRepositoryImpl (
    private val remoteDataSource: TvShowRemoteDataSource,
    private val localTvDbSource: TvShowLocalDatasource,
    private val cacheTVDataSource: TvShowCachedDataSource
        )
    : TvShowRepository {
    override suspend fun getTVShows(): List<TVShow>? {
        return  getTvShowsFromLocalDB()
    }

    override suspend fun updateTVShows(): List<TVShow>? {
        val newTVLIst =getTvShowFromAPI()
            localTvDbSource.clearAllTvShows()
            localTvDbSource.saveTVShowList(newTVLIst)
            cacheTVDataSource.savedTvShows(newTVLIst)
            return newTVLIst
        }


    suspend fun getTvShowFromAPI(): List<TVShow> {
        var tvShowList: List<TVShow> = arrayListOf();
        try{
            val response = remoteDataSource.getTvShowList()
            response.body().let {
                tvShowList=it?.TVShows!!
            }

        }catch (e:Exception){e.printStackTrace()}

        return tvShowList;
    }

    suspend fun getTvShowsFromLocalDB(): List<TVShow>
    {
        var tvShowList: List<TVShow> = arrayListOf();
        try{

            tvShowList=localTvDbSource.getTVShowList();
         }catch (e:Exception){e.printStackTrace()}

        if(tvShowList.size>0){
            return tvShowList
        }else{
            tvShowList=getTvShowFromAPI()
            localTvDbSource.saveTVShowList(tvShowList);
        }
        return tvShowList;

    }
    suspend fun getTvShowsFromCached(): List<TVShow>
    {
        var tvShowList: List<TVShow> = arrayListOf();
        try{
            tvShowList=cacheTVDataSource.getTVshowList();
        }catch (e:Exception){e.printStackTrace()}

        if(tvShowList.size>0){
            return tvShowList
        }else{
            tvShowList=getTvShowsFromLocalDB()
            cacheTVDataSource.savedTvShows(tvShowList);
        }
        return tvShowList;

    }


}