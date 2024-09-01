package com.bounce.snapstore.data.repository

import com.bounce.snapstore.data.network.ApiService
import com.bounce.snapstore.domain.model.ProductCartData
import com.bounce.snapstore.domain.repository.CartsRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class CartsRepositoryImpl @Inject constructor(val apiService: ApiService) : CartsRepository {
    override fun getCarts(): Single<List<ProductCartData>> {
        return apiService.getCarts()
    }
}