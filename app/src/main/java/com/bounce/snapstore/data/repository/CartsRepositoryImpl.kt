package com.bounce.snapstore.data.repository

import com.bounce.snapstore.data.network.ProductApiService
import com.bounce.snapstore.domain.model.ProductCartData
import com.bounce.snapstore.domain.repository.CartsRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class CartsRepositoryImpl @Inject constructor(private val productApiService: ProductApiService) : CartsRepository {
    override fun getProductCarts(): Single<List<ProductCartData>> {
        return productApiService.getProductCarts()
    }
}