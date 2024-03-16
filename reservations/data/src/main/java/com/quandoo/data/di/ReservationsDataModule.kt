package com.quandoo.data.di


import android.app.Application
import androidx.room.Room
import com.example.domain.repository.CustomersRepository
import com.example.domain.repository.ReservationsRepository
import com.example.domain.repository.TablesRepository
import com.quandoo.data.api.RestaurantApi
import com.quandoo.data.database.RestaurantDatabase
import com.quandoo.data.database.RestaurantDatabaseTest
import com.quandoo.data.repositoryImp.CustomersRepositoryImp
import com.quandoo.data.repositoryImp.ReservationsRepositoryImp
import com.quandoo.data.repositoryImp.TablesRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ReservationsDataModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }).build()
    }
    @Provides
    @Singleton
    fun providesRestaurantApi(client: OkHttpClient): RestaurantApi {
        return Retrofit.Builder().baseUrl(RestaurantApi.BASE_URL)
            //PARSE AUTOMATICALLY DE JSON RESPONSE TO OUR DTO OBJECT
            .addConverterFactory(MoshiConverterFactory.create()).client(client).build().create()
    }
//    @Provides
//    @Singleton
//    fun providesRestaurantDatabase(app: Application): RestaurantDatabase {
//        return Room.databaseBuilder(
//            app,
//            RestaurantDatabase::class.java,
//            "restaurant.db",
//        ).build()
//    }


    @Provides
    @Singleton
    fun providesRestaurantDatabase(app: Application): RestaurantDatabaseTest {
        return Room.databaseBuilder(
            app,
            RestaurantDatabaseTest::class.java,
            "restaurant.db.test",
        ).build()
    }

    @Provides
    @Singleton
    fun provideCustomerRepository(
        api: RestaurantApi,
//        db: RestaurantDatabase
        db: RestaurantDatabaseTest
    ): CustomersRepository
    {
        return CustomersRepositoryImp(
            dao = db.customersDao,
            api = api
        )
    }

    @Provides
    @Singleton
    fun provideReservationRepository(
        api: RestaurantApi,
//        db: RestaurantDatabase
        db: RestaurantDatabaseTest
    ): ReservationsRepository
    {
        return ReservationsRepositoryImp(
            reservationDao = db.reservationsDao,
            tablesDao = db.tablesDao,
            api = api
        )
    }

    @Provides
    @Singleton
    fun provideTablesRepository(
        api: RestaurantApi,
//        db: RestaurantDatabase
        db: RestaurantDatabaseTest
    ): TablesRepository
    {
        return TablesRepositoryImp(
            dao = db.tablesDao,
            api = api
        )
    }
}