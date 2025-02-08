package com.bounce.snapstore.domain.repository

import com.bounce.snapstore.domain.model.ProductData
import io.reactivex.rxjava3.core.Single

interface ProductRepository {

    fun getAllProducts(): Single<List<ProductData>>

    fun getProductById(id: Int): Single<ProductData>
}