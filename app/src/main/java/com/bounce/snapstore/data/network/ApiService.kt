package com.bounce.snapstore.data.network

import com.bounce.snapstore.domain.model.ProductCartData
import com.bounce.snapstore.domain.model.ProductData
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/products")
    fun getAllProducts(): Single<List<ProductData>>

    @GET("/products/{id}")
    fun getProductById(@Path("id") id: Int): Single<ProductData>

    @GET("/carts/user/{id}")
    fun getCarts(@Path("id") id: Int = 1): Single<List<ProductCartData>>

}