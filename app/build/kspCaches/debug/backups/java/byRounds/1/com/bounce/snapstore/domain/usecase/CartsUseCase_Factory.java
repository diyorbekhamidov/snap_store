package com.bounce.snapstore.domain.usecase;

import com.bounce.snapstore.domain.repository.CartsRepository;
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
public final class CartsUseCase_Factory implements Factory<CartsUseCase> {
  private final Provider<CartsRepository> cartsRepositoryProvider;

  private final Provider<ProductUseCase> productUseCaseProvider;

  public CartsUseCase_Factory(Provider<CartsRepository> cartsRepositoryProvider,
      Provider<ProductUseCase> productUseCaseProvider) {
    this.cartsRepositoryProvider = cartsRepositoryProvider;
    this.productUseCaseProvider = productUseCaseProvider;
  }

  @Override
  public CartsUseCase get() {
    return newInstance(cartsRepositoryProvider.get(), productUseCaseProvider.get());
  }

  public static CartsUseCase_Factory create(Provider<CartsRepository> cartsRepositoryProvider,
      Provider<ProductUseCase> productUseCaseProvider) {
    return new CartsUseCase_Factory(cartsRepositoryProvider, productUseCaseProvider);
  }

  public static CartsUseCase newInstance(CartsRepository cartsRepository,
      ProductUseCase productUseCase) {
    return new CartsUseCase(cartsRepository, productUseCase);
  }
}
