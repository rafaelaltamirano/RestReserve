package com.quandoo.androidtask.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ReservationsDataModuleTest {

//    @Provides
//    @Singleton
//    fun providesRestaurantDatabaseTest(app: Application): RestaurantDatabaseTest {
//        return Room.databaseBuilder(
//            app,
//            RestaurantDatabaseTest::class.java,
//            "restaurant.db.test",
//        ).build()
//    }

//    @Provides
//    @Singleton
//    fun provideTablesRepository(
//        api: FakeRestaurantApi,
//        db: RestaurantDatabaseTest
//    ): TablesRepository
//    {
//        return com.quandoo.androidtask.repositoryImp.FakeTablesRepositoryImp(
//            dao = db.tablesDao,
//            api = api
//        )
//    }


}
