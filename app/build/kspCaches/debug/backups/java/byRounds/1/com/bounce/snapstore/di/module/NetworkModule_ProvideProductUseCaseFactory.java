package com.bounce.snapstore.di.module;

import com.bounce.snapstore.domain.repository.ProductRepository;
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
public final class NetworkModule_ProvideProductUseCaseFactory implements Factory<ProductUseCase> {
  private final NetworkModule module;

  private final Provider<ProductRepository> productRepositoryProvider;

  public NetworkModule_ProvideProductUseCaseFactory(NetworkModule module,
      Provider<ProductRepository> productRepositoryProvider) {
    this.module = module;
    this.productRepositoryProvider = productRepositoryProvider;
  }

  @Override
  public ProductUseCase get() {
    return provideProductUseCase(module, productRepositoryProvider.get());
  }

  public static NetworkModule_ProvideProductUseCaseFactory create(NetworkModule module,
      Provider<ProductRepository> productRepositoryProvider) {
    return new NetworkModule_ProvideProductUseCaseFactory(module, productRepositoryProvider);
  }

  public static ProductUseCase provideProductUseCase(NetworkModule instance,
      ProductRepository productRepository) {
    return Preconditions.checkNotNullFromProvides(instance.provideProductUseCase(productRepository));
  }
}
