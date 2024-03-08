package com.quandoo.data.di

import com.example.data.local.TablesLocalSourceImp
import com.quandoo.data.local.TablesLocalSourceImp
import com.quandoo.domain.data_source.local.CustomersLocalSource
import com.quandoo.domain.data_source.local.TablesLocalSource
import com.quandoo.data.remote.CustomersRemoteSource
import com.quandoo.data.remote.ReservationsRemoteSource
import com.quandoo.data.remote.TablesRemoteSource
import com.quandoo.domain.data_source.remote.CustomersRemoteSource
import com.quandoo.domain.data_source.remote.ReservationsRemoteSource
import com.quandoo.domain.data_source.remote.TablesRemoteSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Binds
    @Singleton
    abstract fun bindTablesLocalSource(imp: TablesLocalSourceImp): TablesLocalSource

    @Binds
    @Singleton
    abstract fun bindCustomersLocalSource(imp: CustomersLocalSourceImp): CustomersLocalSource

    @Binds
    @Singleton
    abstract fun bindCustomersRemoteSource(imp: CustomersRemoteSourceImp): CustomersRemoteSource

    @Binds
    @Singleton
    abstract fun bindReservationsRemoteSource(imp: ReservationsRemoteSourceImp): ReservationsRemoteSource

    @Binds
    @Singleton
    abstract fun bindTablesRemoteSource(imp: TablesRemoteSourceImp): TablesRemoteSource

}