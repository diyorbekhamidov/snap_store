package com.bounce.snapstore.di.module;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class NetworkModule_ProvideBaseUrlFactory implements Factory<String> {
  private final NetworkModule module;

  public NetworkModule_ProvideBaseUrlFactory(NetworkModule module) {
    this.module = module;
  }

  @Override
  public String get() {
    return provideBaseUrl(module);
  }

  public static NetworkModule_ProvideBaseUrlFactory create(NetworkModule module) {
    return new NetworkModule_ProvideBaseUrlFactory(module);
  }

  public static String provideBaseUrl(NetworkModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.provideBaseUrl());
  }
}
