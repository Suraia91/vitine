package com.suraia.andela.vitrine.data.di

import com.suraia.andela.vitrine.data.services.VitrineService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun provideOkHttp(): OkHttpClient{
        return OkHttpClient.Builder().build()
    }
    @Singleton
    @Provides
    @Named("loggingInterceptor")
    fun provideLoggingInterceptor(): HttpLoggingInterceptor{

        return HttpLoggingInterceptor().apply { this.level=HttpLoggingInterceptor.Level.BODY }
    }
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient):Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://essca-api.herokuapp.com/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }
    @Provides
    fun provideApiClient(retrofit: Retrofit):VitrineService{
        return retrofit.create(VitrineService::class.java)
    }
}