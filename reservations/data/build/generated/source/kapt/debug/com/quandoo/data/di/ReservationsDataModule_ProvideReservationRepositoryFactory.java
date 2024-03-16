package com.quandoo.data.di;

import com.example.domain.repository.ReservationsRepository;
import com.quandoo.data.api.RestaurantApi;
import com.quandoo.data.database.RestaurantDatabaseTest;
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
public final class ReservationsDataModule_ProvideReservationRepositoryFactory implements Factory<ReservationsRepository> {
  private final Provider<RestaurantApi> apiProvider;

  private final Provider<RestaurantDatabaseTest> dbProvider;

  public ReservationsDataModule_ProvideReservationRepositoryFactory(
      Provider<RestaurantApi> apiProvider, Provider<RestaurantDatabaseTest> dbProvider) {
    this.apiProvider = apiProvider;
    this.dbProvider = dbProvider;
  }

  @Override
  public ReservationsRepository get() {
    return provideReservationRepository(apiProvider.get(), dbProvider.get());
  }

  public static ReservationsDataModule_ProvideReservationRepositoryFactory create(
      Provider<RestaurantApi> apiProvider, Provider<RestaurantDatabaseTest> dbProvider) {
    return new ReservationsDataModule_ProvideReservationRepositoryFactory(apiProvider, dbProvider);
  }

  public static ReservationsRepository provideReservationRepository(RestaurantApi api,
      RestaurantDatabaseTest db) {
    return Preconditions.checkNotNullFromProvides(ReservationsDataModule.INSTANCE.provideReservationRepository(api, db));
  }
}
