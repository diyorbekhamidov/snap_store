package com.bounce.snapstore.presentation.di.module

import com.bounce.snapstore.data.network.ApiService
import com.bounce.snapstore.data.repository.CartsRepositoryImpl
import com.bounce.snapstore.data.repository.ProductRepositoryImpl
import com.bounce.snapstore.domain.repository.CartsRepository
import com.bounce.snapstore.domain.repository.ProductRepository
import com.bounce.snapstore.domain.usecase.CartsUseCase
import com.bounce.snapstore.domain.usecase.ProductUseCase
import dagger.Module
import dagger.Provides
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class NetworkModule {

    @Provides
    @Singleton
    fun provideBaseUrl(): String {
        return "https://fakestoreapi.com/"
    }

    @Provides
    @Singleton
    fun provideGsonConvertorFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Provides
    @Singleton
    fun provideRxJavaCallAdapterFactory(): RxJava3CallAdapterFactory {
        return RxJava3CallAdapterFactory.create()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        baseUrl: String,
        converterFactory: GsonConverterFactory,
        rxJava3CallAdapterFactory: RxJava3CallAdapterFactory
    ): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(converterFactory)
            .addCallAdapterFactory(rxJava3CallAdapterFactory)
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideProductRepository(apiService: ApiService): ProductRepository {
        return ProductRepositoryImpl(apiService)
    }

    @Provides
    @Singleton
    fun provideProductUseCase(productRepository: ProductRepository): ProductUseCase {
        return ProductUseCase(productRepository)
    }

    @Provides
    @Singleton
    fun provideCartsRepository(apiService: ApiService): CartsRepository {
        return CartsRepositoryImpl(apiService)
    }

    @Provides
    @Singleton
    fun provideCartsUseCase(
        cartsRepository: CartsRepository,
        productUseCase: ProductUseCase
    ): CartsUseCase {
        return CartsUseCase(cartsRepository, productUseCase)
    }


}