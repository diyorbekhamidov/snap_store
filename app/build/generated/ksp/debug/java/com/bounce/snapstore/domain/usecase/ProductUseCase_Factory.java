package com.bounce.snapstore.domain.usecase;

import com.bounce.snapstore.domain.repository.ProductRepository;
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
public final class ProductUseCase_Factory implements Factory<ProductUseCase> {
  private final Provider<ProductRepository> productRepositoryProvider;

  public ProductUseCase_Factory(Provider<ProductRepository> productRepositoryProvider) {
    this.productRepositoryProvider = productRepositoryProvider;
  }

  @Override
  public ProductUseCase get() {
    return newInstance(productRepositoryProvider.get());
  }

  public static ProductUseCase_Factory create(
      Provider<ProductRepository> productRepositoryProvider) {
    return new ProductUseCase_Factory(productRepositoryProvider);
  }

  public static ProductUseCase newInstance(ProductRepository productRepository) {
    return new ProductUseCase(productRepository);
  }
}
