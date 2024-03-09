package com.quandoo.data.di

import com.example.domain.constants.BASE_URL_API
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS).build()
    }

    @Singleton
    @Provides
    fun providesBooksApi(client: OkHttpClient): com.quandoo.data.api.RestaurantApi {
        val builder = Retrofit.Builder().baseUrl(BASE_URL_API)
            .addConverterFactory(GsonConverterFactory.create())
        client.also(builder::client)
        return builder.build().create(com.quandoo.data.api.RestaurantApi::class.java)
    }

}