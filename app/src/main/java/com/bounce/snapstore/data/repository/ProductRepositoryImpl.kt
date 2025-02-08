package com.bounce.snapstore.data.repository

import com.bounce.snapstore.data.network.ProductApiService
import com.bounce.snapstore.domain.model.ProductData
import com.bounce.snapstore.domain.repository.ProductRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(private val productApiService: ProductApiService): ProductRepository {
    override fun getAllProducts(): Single<List<ProductData>> {
        return productApiService.getAllProducts()
    }

    override fun getProductById(id: Int): Single<ProductData> {
        return productApiService.getProductById(id)
    }

}