package com.quandoo.data.di;

import com.quandoo.data.api.RestaurantApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

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
public final class ReservationsDataModule_ProvidesRestaurantApiFactory implements Factory<RestaurantApi> {
  private final Provider<OkHttpClient> clientProvider;

  public ReservationsDataModule_ProvidesRestaurantApiFactory(
      Provider<OkHttpClient> clientProvider) {
    this.clientProvider = clientProvider;
  }

  @Override
  public RestaurantApi get() {
    return providesRestaurantApi(clientProvider.get());
  }

  public static ReservationsDataModule_ProvidesRestaurantApiFactory create(
      Provider<OkHttpClient> clientProvider) {
    return new ReservationsDataModule_ProvidesRestaurantApiFactory(clientProvider);
  }

  public static RestaurantApi providesRestaurantApi(OkHttpClient client) {
    return Preconditions.checkNotNullFromProvides(ReservationsDataModule.INSTANCE.providesRestaurantApi(client));
  }
}
