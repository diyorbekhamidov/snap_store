package com.bounce.snapstore.domain.usecase

import com.bounce.snapstore.domain.model.ProductCartData
import com.bounce.snapstore.domain.model.ProductData
import com.bounce.snapstore.domain.repository.CartsRepository
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class CartsUseCase @Inject constructor(
    private val cartsRepository: CartsRepository,
    val productUseCase: ProductUseCase
) {
    fun getProductCarts(): Single<Pair<List<ProductCartData>, List<ProductData>>> {
        return cartsRepository.getProductCarts()
            .flatMap { productCartsList ->

                val productSingles = productCartsList.map { cart ->
                    Single.zip(
                        cart.products.map { productUseCase.getProductById(it.productId) }
                    ) { productsArray ->
                        cart to productsArray.map { it as ProductData }
                    }
                }

                Single.zip(productSingles) { pairsArray ->
                    val pairs = pairsArray.map { it as Pair<ProductCartData, List<ProductData>> }
                    val carts = pairs.map { it.first }
                    val products = pairs.flatMap { it.second }
                    carts to products
                }
            }
    }
}