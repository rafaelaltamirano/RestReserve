package com.quandoo.data.di;

import com.example.domain.repository.CustomersRepository;
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
public final class ReservationsDataModule_ProvideCustomerRepositoryFactory implements Factory<CustomersRepository> {
  private final Provider<RestaurantApi> apiProvider;

  private final Provider<RestaurantDatabase> dbProvider;

  public ReservationsDataModule_ProvideCustomerRepositoryFactory(
      Provider<RestaurantApi> apiProvider, Provider<RestaurantDatabase> dbProvider) {
    this.apiProvider = apiProvider;
    this.dbProvider = dbProvider;
  }

  @Override
  public CustomersRepository get() {
    return provideCustomerRepository(apiProvider.get(), dbProvider.get());
  }

  public static ReservationsDataModule_ProvideCustomerRepositoryFactory create(
      Provider<RestaurantApi> apiProvider, Provider<RestaurantDatabase> dbProvider) {
    return new ReservationsDataModule_ProvideCustomerRepositoryFactory(apiProvider, dbProvider);
  }

  public static CustomersRepository provideCustomerRepository(RestaurantApi api,
      RestaurantDatabase db) {
    return Preconditions.checkNotNullFromProvides(ReservationsDataModule.INSTANCE.provideCustomerRepository(api, db));
  }
}
