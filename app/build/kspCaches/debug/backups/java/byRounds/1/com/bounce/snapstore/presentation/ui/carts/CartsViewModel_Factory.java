package com.bounce.snapstore.presentation.ui.carts;

import com.bounce.snapstore.domain.usecase.CartsUseCase;
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
public final class CartsViewModel_Factory implements Factory<CartsViewModel> {
  private final Provider<CartsUseCase> cartsUseCaseProvider;

  public CartsViewModel_Factory(Provider<CartsUseCase> cartsUseCaseProvider) {
    this.cartsUseCaseProvider = cartsUseCaseProvider;
  }

  @Override
  public CartsViewModel get() {
    return newInstance(cartsUseCaseProvider.get());
  }

  public static CartsViewModel_Factory create(Provider<CartsUseCase> cartsUseCaseProvider) {
    return new CartsViewModel_Factory(cartsUseCaseProvider);
  }

  public static CartsViewModel newInstance(CartsUseCase cartsUseCase) {
    return new CartsViewModel(cartsUseCase);
  }
}
