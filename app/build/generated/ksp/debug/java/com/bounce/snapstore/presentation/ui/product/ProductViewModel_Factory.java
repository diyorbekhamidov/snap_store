package com.bounce.snapstore.presentation.ui.product;

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
public final class ProductViewModel_Factory implements Factory<ProductViewModel> {
  private final Provider<ProductUseCase> productUseCaseProvider;

  public ProductViewModel_Factory(Provider<ProductUseCase> productUseCaseProvider) {
    this.productUseCaseProvider = productUseCaseProvider;
  }

  @Override
  public ProductViewModel get() {
    return newInstance(productUseCaseProvider.get());
  }

  public static ProductViewModel_Factory create(Provider<ProductUseCase> productUseCaseProvider) {
    return new ProductViewModel_Factory(productUseCaseProvider);
  }

  public static ProductViewModel newInstance(ProductUseCase productUseCase) {
    return new ProductViewModel(productUseCase);
  }
}
