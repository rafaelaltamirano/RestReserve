package com.quandoo.data.di;

@dagger.Module
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0007\u00a8\u0006\b"}, d2 = {"Lcom/quandoo/data/di/ApiModule;", "", "()V", "provideHttpClient", "Lokhttp3/OkHttpClient;", "providesBooksApi", "Lcom/quandoo/data/api/RestaurantApi;", "client", "data_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class ApiModule {
    @org.jetbrains.annotations.NotNull
    public static final com.quandoo.data.di.ApiModule INSTANCE = null;
    
    private ApiModule() {
        super();
    }
    
    @javax.inject.Singleton
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final okhttp3.OkHttpClient provideHttpClient() {
        return null;
    }
    
    @javax.inject.Singleton
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final com.quandoo.data.api.RestaurantApi providesBooksApi(@org.jetbrains.annotations.NotNull
    okhttp3.OkHttpClient client) {
        return null;
    }
}