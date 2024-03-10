package com.quandoo.data.di;

import com.example.domain.repository.TablesRepository;
import com.quandoo.data.api.RestaurantApi;
import com.quandoo.data.database.RestaurantDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class ReservationsDataModule_ProvideTablesRepositoryFactory implements Factory<TablesRepository> {
  private final Provider<RestaurantApi> apiProvider;

  private final Provider<RestaurantDatabase> dbProvider;

  public ReservationsDataModule_ProvideTablesRepositoryFactory(Provider<RestaurantApi> apiProvider,
      Provider<RestaurantDatabase> dbProvider) {
    this.apiProvider = apiProvider;
    this.dbProvider = dbProvider;
  }

  @Override
  public TablesRepository get() {
    return provideTablesRepository(apiProvider.get(), dbProvider.get());
  }

  public static ReservationsDataModule_ProvideTablesRepositoryFactory create(
      Provider<RestaurantApi> apiProvider, Provider<RestaurantDatabase> dbProvider) {
    return new ReservationsDataModule_ProvideTablesRepositoryFactory(apiProvider, dbProvider);
  }

  public static TablesRepository provideTablesRepository(RestaurantApi api, RestaurantDatabase db) {
    return Preconditions.checkNotNullFromProvides(ReservationsDataModule.INSTANCE.provideTablesRepository(api, db));
  }
}
