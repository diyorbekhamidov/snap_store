package com.bounce.snapstore.di.module;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;
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
public final class NetworkModule_ProvideRetrofitFactory implements Factory<Retrofit> {
  private final NetworkModule module;

  private final Provider<String> baseUrlProvider;

  private final Provider<GsonConverterFactory> converterFactoryProvider;

  private final Provider<RxJava3CallAdapterFactory> rxJava3CallAdapterFactoryProvider;

  public NetworkModule_ProvideRetrofitFactory(NetworkModule module,
      Provider<String> baseUrlProvider, Provider<GsonConverterFactory> converterFactoryProvider,
      Provider<RxJava3CallAdapterFactory> rxJava3CallAdapterFactoryProvider) {
    this.module = module;
    this.baseUrlProvider = baseUrlProvider;
    this.converterFactoryProvider = converterFactoryProvider;
    this.rxJava3CallAdapterFactoryProvider = rxJava3CallAdapterFactoryProvider;
  }

  @Override
  public Retrofit get() {
    return provideRetrofit(module, baseUrlProvider.get(), converterFactoryProvider.get(), rxJava3CallAdapterFactoryProvider.get());
  }

  public static NetworkModule_ProvideRetrofitFactory create(NetworkModule module,
      Provider<String> baseUrlProvider, Provider<GsonConverterFactory> converterFactoryProvider,
      Provider<RxJava3CallAdapterFactory> rxJava3CallAdapterFactoryProvider) {
    return new NetworkModule_ProvideRetrofitFactory(module, baseUrlProvider, converterFactoryProvider, rxJava3CallAdapterFactoryProvider);
  }

  public static Retrofit provideRetrofit(NetworkModule instance, String baseUrl,
      GsonConverterFactory converterFactory, RxJava3CallAdapterFactory rxJava3CallAdapterFactory) {
    return Preconditions.checkNotNullFromProvides(instance.provideRetrofit(baseUrl, converterFactory, rxJava3CallAdapterFactory));
  }
}
