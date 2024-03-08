package com.quandoo.data.di

import android.content.Context
import androidx.room.Room
import com.quandoo.data.database.AppDatabase
import com.quandoo.data.dao.TablesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {


    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): com.quandoo.data.database.AppDatabase {
        return Room.databaseBuilder(
            appContext, com.quandoo.data.database.AppDatabase::class.java, "restaurant_db"
        ).build()
    }

    @Provides
    fun providedBooksDao(appDatabase: com.quandoo.data.database.AppDatabase): TablesDao {
        return appDatabase.TablesDao()
    }

}
