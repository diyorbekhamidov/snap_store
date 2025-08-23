package com.bounce.snapstore.presentation.ui.search;

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
public final class SearchFragment_MembersInjector implements MembersInjector<SearchFragment> {
  private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

  public SearchFragment_MembersInjector(
      Provider<ViewModelProvider.Factory> viewModelFactoryProvider) {
    this.viewModelFactoryProvider = viewModelFactoryProvider;
  }

  public static MembersInjector<SearchFragment> create(
      Provider<ViewModelProvider.Factory> viewModelFactoryProvider) {
    return new SearchFragment_MembersInjector(viewModelFactoryProvider);
  }

  @Override
  public void injectMembers(SearchFragment instance) {
    injectViewModelFactory(instance, viewModelFactoryProvider.get());
  }

  @InjectedFieldSignature("com.bounce.snapstore.presentation.ui.search.SearchFragment.viewModelFactory")
  public static void injectViewModelFactory(SearchFragment instance,
      ViewModelProvider.Factory viewModelFactory) {
    instance.viewModelFactory = viewModelFactory;
  }
}
