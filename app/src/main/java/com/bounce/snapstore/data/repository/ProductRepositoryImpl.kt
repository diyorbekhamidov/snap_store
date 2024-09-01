package com.bounce.snapstore.data.repository

import com.bounce.snapstore.data.network.ApiService
import com.bounce.snapstore.domain.model.ProductCartData
import com.bounce.snapstore.domain.model.ProductData
import com.bounce.snapstore.domain.repository.ProductRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(val apiService: ApiService): ProductRepository {
    override fun getProducts(): Single<List<ProductData>> {
        return apiService.getAllProducts()
    }

    override fun getProductById(id: Int): Single<ProductData> {
        return apiService.getProductById(id)
    }

}