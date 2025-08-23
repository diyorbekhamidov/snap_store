package com.bounce.snapstore.data.repository;

import com.bounce.snapstore.data.network.ProductApiService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
    "KotlinInternalInJava",
    "cast"
})
public final class CartsRepositoryImpl_Factory implements Factory<CartsRepositoryImpl> {
  private final Provider<ProductApiService> productApiServiceProvider;

  public CartsRepositoryImpl_Factory(Provider<ProductApiService> productApiServiceProvider) {
    this.productApiServiceProvider = productApiServiceProvider;
  }

  @Override
  public CartsRepositoryImpl get() {
    return newInstance(productApiServiceProvider.get());
  }

  public static CartsRepositoryImpl_Factory create(
      Provider<ProductApiService> productApiServiceProvider) {
    return new CartsRepositoryImpl_Factory(productApiServiceProvider);
  }

  public static CartsRepositoryImpl newInstance(ProductApiService productApiService) {
    return new CartsRepositoryImpl(productApiService);
  }
}
