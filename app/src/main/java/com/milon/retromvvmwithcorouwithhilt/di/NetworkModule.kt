package com.milon.retromvvmwithcorouwithhilt.di

import com.milon.retromvvmwithcorouwithhilt.retrofit.FakerApi
import com.milon.retromvvmwithcorouwithhilt.utils.Constants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
              .addConverterFactory(GsonConverterFactory.create())
              .build()
    }

    @Singleton
    @Provides
    fun providesFakerApi(retrofit: Retrofit): FakerApi{
        return retrofit.create(FakerApi::class.java)
    }
}