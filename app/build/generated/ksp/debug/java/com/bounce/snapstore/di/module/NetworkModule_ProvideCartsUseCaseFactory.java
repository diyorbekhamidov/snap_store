package com.bounce.snapstore.di.module;

import com.bounce.snapstore.domain.repository.CartsRepository;
import com.bounce.snapstore.domain.usecase.CartsUseCase;
import com.bounce.snapstore.domain.usecase.ProductUseCase;
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
    "KotlinInternalInJava",
    "cast"
})
public final class NetworkModule_ProvideCartsUseCaseFactory implements Factory<CartsUseCase> {
  private final NetworkModule module;

  private final Provider<CartsRepository> cartsRepositoryProvider;

  private final Provider<ProductUseCase> productUseCaseProvider;

  public NetworkModule_ProvideCartsUseCaseFactory(NetworkModule module,
      Provider<CartsRepository> cartsRepositoryProvider,
      Provider<ProductUseCase> productUseCaseProvider) {
    this.module = module;
    this.cartsRepositoryProvider = cartsRepositoryProvider;
    this.productUseCaseProvider = productUseCaseProvider;
  }

  @Override
  public CartsUseCase get() {
    return provideCartsUseCase(module, cartsRepositoryProvider.get(), productUseCaseProvider.get());
  }

  public static NetworkModule_ProvideCartsUseCaseFactory create(NetworkModule module,
      Provider<CartsRepository> cartsRepositoryProvider,
      Provider<ProductUseCase> productUseCaseProvider) {
    return new NetworkModule_ProvideCartsUseCaseFactory(module, cartsRepositoryProvider, productUseCaseProvider);
  }

  public static CartsUseCase provideCartsUseCase(NetworkModule instance,
      CartsRepository cartsRepository, ProductUseCase productUseCase) {
    return Preconditions.checkNotNullFromProvides(instance.provideCartsUseCase(cartsRepository, productUseCase));
  }
}
