package com.bounce.snapstore.di.module;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import retrofit2.converter.gson.GsonConverterFactory;

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
public final class NetworkModule_ProvideGsonConvertorFactoryFactory implements Factory<GsonConverterFactory> {
  private final NetworkModule module;

  public NetworkModule_ProvideGsonConvertorFactoryFactory(NetworkModule module) {
    this.module = module;
  }

  @Override
  public GsonConverterFactory get() {
    return provideGsonConvertorFactory(module);
  }

  public static NetworkModule_ProvideGsonConvertorFactoryFactory create(NetworkModule module) {
    return new NetworkModule_ProvideGsonConvertorFactoryFactory(module);
  }

  public static GsonConverterFactory provideGsonConvertorFactory(NetworkModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.provideGsonConvertorFactory());
  }
}
