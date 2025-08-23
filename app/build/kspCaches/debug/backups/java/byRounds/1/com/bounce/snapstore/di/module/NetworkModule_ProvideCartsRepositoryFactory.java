package com.bounce.snapstore.di.module;

import com.bounce.snapstore.data.network.ProductApiService;
import com.bounce.snapstore.domain.repository.CartsRepository;
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
public final class NetworkModule_ProvideCartsRepositoryFactory implements Factory<CartsRepository> {
  private final NetworkModule module;

  private final Provider<ProductApiService> apiServiceProvider;

  public NetworkModule_ProvideCartsRepositoryFactory(NetworkModule module,
      Provider<ProductApiService> apiServiceProvider) {
    this.module = module;
    this.apiServiceProvider = apiServiceProvider;
  }

  @Override
  public CartsRepository get() {
    return provideCartsRepository(module, apiServiceProvider.get());
  }

  public static NetworkModule_ProvideCartsRepositoryFactory create(NetworkModule module,
      Provider<ProductApiService> apiServiceProvider) {
    return new NetworkModule_ProvideCartsRepositoryFactory(module, apiServiceProvider);
  }

  public static CartsRepository provideCartsRepository(NetworkModule instance,
      ProductApiService apiService) {
    return Preconditions.checkNotNullFromProvides(instance.provideCartsRepository(apiService));
  }
}
