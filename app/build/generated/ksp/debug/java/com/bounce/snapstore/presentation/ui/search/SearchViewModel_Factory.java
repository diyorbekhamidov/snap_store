package com.bounce.snapstore.presentation.ui.search;

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
public final class SearchViewModel_Factory implements Factory<SearchViewModel> {
  private final Provider<ProductUseCase> productUseCaseProvider;

  public SearchViewModel_Factory(Provider<ProductUseCase> productUseCaseProvider) {
    this.productUseCaseProvider = productUseCaseProvider;
  }

  @Override
  public SearchViewModel get() {
    return newInstance(productUseCaseProvider.get());
  }

  public static SearchViewModel_Factory create(Provider<ProductUseCase> productUseCaseProvider) {
    return new SearchViewModel_Factory(productUseCaseProvider);
  }

  public static SearchViewModel newInstance(ProductUseCase productUseCase) {
    return new SearchViewModel(productUseCase);
  }
}
