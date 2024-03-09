package com.quandoo.data.di;

@dagger.Module
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0015\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\tH\'\u00a2\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\rH\'\u00a8\u0006\u000e"}, d2 = {"Lcom/quandoo/data/di/DataSourceModule;", "", "()V", "bindCustomersLocalSource", "Lcom/quandoo/domain/data_source/local/CustomersLocalSource;", "imp", "Lcom/quandoo/data/data_source/local/CustomersLocalSourceImp;", "bindRestaurantRemoteSource", "error/NonExistentClass", "Lcom/quandoo/data/data_source/remote/RestaurantRemoteSourceImp;", "(Lcom/quandoo/data/data_source/remote/RestaurantRemoteSourceImp;)Lerror/NonExistentClass;", "bindTablesLocalSource", "Lcom/quandoo/domain/data_source/local/TablesLocalSource;", "Lcom/quandoo/data/data_source/local/TablesLocalSourceImp;", "data_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public abstract class DataSourceModule {
    
    public DataSourceModule() {
        super();
    }
    
    @dagger.Binds
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public abstract com.quandoo.domain.data_source.local.TablesLocalSource bindTablesLocalSource(@org.jetbrains.annotations.NotNull
    com.quandoo.data.data_source.local.TablesLocalSourceImp imp);
    
    @dagger.Binds
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public abstract com.quandoo.domain.data_source.local.CustomersLocalSource bindCustomersLocalSource(@org.jetbrains.annotations.NotNull
    com.quandoo.data.data_source.local.CustomersLocalSourceImp imp);
    
    @dagger.Binds
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public abstract error.NonExistentClass bindRestaurantRemoteSource(@org.jetbrains.annotations.NotNull
    com.quandoo.data.data_source.remote.RestaurantRemoteSourceImp imp);
}