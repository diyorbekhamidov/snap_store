package com.bounce.snapstore.presentation.ui.product;

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
public final class ProductFragment_MembersInjector implements MembersInjector<ProductFragment> {
  private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

  public ProductFragment_MembersInjector(
      Provider<ViewModelProvider.Factory> viewModelFactoryProvider) {
    this.viewModelFactoryProvider = viewModelFactoryProvider;
  }

  public static MembersInjector<ProductFragment> create(
      Provider<ViewModelProvider.Factory> viewModelFactoryProvider) {
    return new ProductFragment_MembersInjector(viewModelFactoryProvider);
  }

  @Override
  public void injectMembers(ProductFragment instance) {
    injectViewModelFactory(instance, viewModelFactoryProvider.get());
  }

  @InjectedFieldSignature("com.bounce.snapstore.presentation.ui.product.ProductFragment.viewModelFactory")
  public static void injectViewModelFactory(ProductFragment instance,
      ViewModelProvider.Factory viewModelFactory) {
    instance.viewModelFactory = viewModelFactory;
  }
}
