package com.bounce.snapstore.presentation.ui.home;

import com.bounce.snapstore.domain.usecase.ProductUseCase;
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
public final class HomeViewModel_Factory implements Factory<HomeViewModel> {
  private final Provider<ProductUseCase> productUseCaseProvider;

  public HomeViewModel_Factory(Provider<ProductUseCase> productUseCaseProvider) {
    this.productUseCaseProvider = productUseCaseProvider;
  }

  @Override
  public HomeViewModel get() {
    return newInstance(productUseCaseProvider.get());
  }

  public static HomeViewModel_Factory create(Provider<ProductUseCase> productUseCaseProvider) {
    return new HomeViewModel_Factory(productUseCaseProvider);
  }

  public static HomeViewModel newInstance(ProductUseCase productUseCase) {
    return new HomeViewModel(productUseCase);
  }
}
