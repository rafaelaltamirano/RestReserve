package com.quandoo.data.di;

import android.app.Application;
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
public final class ReservationsDataModule_ProvidesRestaurantDatabaseFactory implements Factory<RestaurantDatabaseTest> {
  private final Provider<Application> appProvider;

  public ReservationsDataModule_ProvidesRestaurantDatabaseFactory(
      Provider<Application> appProvider) {
    this.appProvider = appProvider;
  }

  @Override
  public RestaurantDatabaseTest get() {
    return providesRestaurantDatabase(appProvider.get());
  }

  public static ReservationsDataModule_ProvidesRestaurantDatabaseFactory create(
      Provider<Application> appProvider) {
    return new ReservationsDataModule_ProvidesRestaurantDatabaseFactory(appProvider);
  }

  public static RestaurantDatabaseTest providesRestaurantDatabase(Application app) {
    return Preconditions.checkNotNullFromProvides(ReservationsDataModule.INSTANCE.providesRestaurantDatabase(app));
  }
}
