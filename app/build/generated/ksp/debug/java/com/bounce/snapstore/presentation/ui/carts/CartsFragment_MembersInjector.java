package com.bounce.snapstore.presentation.ui.carts;

import androidx.lifecycle.ViewModelProvider;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class CartsFragment_MembersInjector implements MembersInjector<CartsFragment> {
  private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

  public CartsFragment_MembersInjector(
      Provider<ViewModelProvider.Factory> viewModelFactoryProvider) {
    this.viewModelFactoryProvider = viewModelFactoryProvider;
  }

  public static MembersInjector<CartsFragment> create(
      Provider<ViewModelProvider.Factory> viewModelFactoryProvider) {
    return new CartsFragment_MembersInjector(viewModelFactoryProvider);
  }

  @Override
  public void injectMembers(CartsFragment instance) {
    injectViewModelFactory(instance, viewModelFactoryProvider.get());
  }

  @InjectedFieldSignature("com.bounce.snapstore.presentation.ui.carts.CartsFragment.viewModelFactory")
  public static void injectViewModelFactory(CartsFragment instance,
      ViewModelProvider.Factory viewModelFactory) {
    instance.viewModelFactory = viewModelFactory;
  }
}
