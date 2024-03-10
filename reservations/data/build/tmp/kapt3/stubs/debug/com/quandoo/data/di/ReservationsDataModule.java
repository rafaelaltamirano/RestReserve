package com.quandoo.data.di;

@dagger.Module
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\nH\u0007J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\nH\u0007J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0007\u00a8\u0006\u0014"}, d2 = {"Lcom/quandoo/data/di/ReservationsDataModule;", "", "()V", "provideCustomerRepository", "Lcom/example/domain/repository/CustomersRepository;", "api", "Lcom/quandoo/data/api/RestaurantApi;", "db", "Lcom/quandoo/data/database/RestaurantDatabase;", "provideOkHttpClient", "Lokhttp3/OkHttpClient;", "provideReservationRepository", "Lcom/example/domain/repository/ReservationsRepository;", "provideTablesRepository", "Lcom/example/domain/repository/TablesRepository;", "providesRestaurantApi", "client", "providesRestaurantDatabase", "app", "Landroid/app/Application;", "data_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class ReservationsDataModule {
    @org.jetbrains.annotations.NotNull
    public static final com.quandoo.data.di.ReservationsDataModule INSTANCE = null;
    
    private ReservationsDataModule() {
        super();
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final okhttp3.OkHttpClient provideOkHttpClient() {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.quandoo.data.api.RestaurantApi providesRestaurantApi(@org.jetbrains.annotations.NotNull
    okhttp3.OkHttpClient client) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.quandoo.data.database.RestaurantDatabase providesRestaurantDatabase(@org.jetbrains.annotations.NotNull
    android.app.Application app) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.example.domain.repository.CustomersRepository provideCustomerRepository(@org.jetbrains.annotations.NotNull
    com.quandoo.data.api.RestaurantApi api, @org.jetbrains.annotations.NotNull
    com.quandoo.data.database.RestaurantDatabase db) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.example.domain.repository.ReservationsRepository provideReservationRepository(@org.jetbrains.annotations.NotNull
    com.quandoo.data.api.RestaurantApi api, @org.jetbrains.annotations.NotNull
    com.quandoo.data.database.RestaurantDatabase db) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.example.domain.repository.TablesRepository provideTablesRepository(@org.jetbrains.annotations.NotNull
    com.quandoo.data.api.RestaurantApi api, @org.jetbrains.annotations.NotNull
    com.quandoo.data.database.RestaurantDatabase db) {
        return null;
    }
}