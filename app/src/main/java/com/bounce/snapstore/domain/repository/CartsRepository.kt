package com.bounce.snapstore.domain.repository

import com.bounce.snapstore.domain.model.ProductCartData
import io.reactivex.rxjava3.core.Single

interface CartsRepository {

    fun getCarts(): Single<List<ProductCartData>>
}