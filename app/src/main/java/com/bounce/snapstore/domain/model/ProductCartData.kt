package com.bounce.snapstore.domain.model

data class ProductCartData(
    val __v: Int,
    val date: String,
    val id: Int,
    val products: List<Product>,
    val userId: Int
)