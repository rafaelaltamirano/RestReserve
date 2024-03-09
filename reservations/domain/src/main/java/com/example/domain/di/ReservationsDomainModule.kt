package com.example.domain.di

import com.example.domain.repository.ReservationsRepository
import com.example.domain.repository.TablesRepository
import com.example.domain.use_case.GetReservations
import com.example.domain.use_case.GetTables
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object ReservationsDomainModule {
    @Provides
    @ViewModelScoped
    fun provideGetTablesUseCase(
        repository: TablesRepository,
    ): GetTables {
        return GetTables(
            repository = repository
        )
    }

    @Provides
    @ViewModelScoped
    fun provideGetReservationsUseCase(
        repository: ReservationsRepository,
    ): GetReservations {
        return GetReservations(
            repository = repository
        )
    }
}