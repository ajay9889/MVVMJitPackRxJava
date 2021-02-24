package com.anushka.tmdbclient.presentation.di.core

import com.anushka.tmdbclient.data.api.TMDBService
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
class NetModule (private val baseUrl: String) {
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit{
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .client(
             OkHttpClient.Builder()
             .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC))
             .connectTimeout(30, TimeUnit.SECONDS)
             .writeTimeout(1, TimeUnit.MINUTES)
             .readTimeout(30, TimeUnit.SECONDS)
             .retryOnConnectionFailure(true)
            .build()
            )
            .build()
    }

    @Singleton
    @Provides
    fun provideTmDbService(retrofit: Retrofit) : TMDBService{
        return retrofit.create(TMDBService::class.java)
    }

}