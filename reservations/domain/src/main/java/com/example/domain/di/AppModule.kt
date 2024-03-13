package com.example.domain.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.example.domain.preferences.DefaultPreferences
import com.example.domain.preferences.Preferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideSharedPreferences(app: Application): SharedPreferences = app.getSharedPreferences("shared_pref",
        Context.MODE_PRIVATE
    )
    @Provides
    @Singleton
    fun providePreferences(sharedPreferences: SharedPreferences): Preferences = DefaultPreferences(sharedPreferences)

}
