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
public final class ProductRepositoryImpl_Factory implements Factory<ProductRepositoryImpl> {
  private final Provider<ProductApiService> productApiServiceProvider;

  public ProductRepositoryImpl_Factory(Provider<ProductApiService> productApiServiceProvider) {
    this.productApiServiceProvider = productApiServiceProvider;
  }

  @Override
  public ProductRepositoryImpl get() {
    return newInstance(productApiServiceProvider.get());
  }

  public static ProductRepositoryImpl_Factory create(
      Provider<ProductApiService> productApiServiceProvider) {
    return new ProductRepositoryImpl_Factory(productApiServiceProvider);
  }

  public static ProductRepositoryImpl newInstance(ProductApiService productApiService) {
    return new ProductRepositoryImpl(productApiService);
  }
}
