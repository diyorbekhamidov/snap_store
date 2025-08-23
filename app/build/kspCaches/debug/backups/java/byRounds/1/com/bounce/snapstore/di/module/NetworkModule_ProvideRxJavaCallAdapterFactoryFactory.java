package com.bounce.snapstore.di.module;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
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
public final class NetworkModule_ProvideRxJavaCallAdapterFactoryFactory implements Factory<RxJava3CallAdapterFactory> {
  private final NetworkModule module;

  public NetworkModule_ProvideRxJavaCallAdapterFactoryFactory(NetworkModule module) {
    this.module = module;
  }

  @Override
  public RxJava3CallAdapterFactory get() {
    return provideRxJavaCallAdapterFactory(module);
  }

  public static NetworkModule_ProvideRxJavaCallAdapterFactoryFactory create(NetworkModule module) {
    return new NetworkModule_ProvideRxJavaCallAdapterFactoryFactory(module);
  }

  public static RxJava3CallAdapterFactory provideRxJavaCallAdapterFactory(NetworkModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.provideRxJavaCallAdapterFactory());
  }
}
