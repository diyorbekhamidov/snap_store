package com.bounce.snapstore.domain.usecase

import com.bounce.snapstore.domain.model.ProductCartData
import com.bounce.snapstore.domain.model.ProductData
import com.bounce.snapstore.domain.repository.CartsRepository
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import java.util.Collections
import javax.inject.Inject

class CartsUseCase @Inject constructor(
    val cartsRepository: CartsRepository,
    val productUseCase: ProductUseCase
) {

    fun getCarts(): Single<Pair<List<ProductCartData>, List<ProductData>>> {
        return cartsRepository.getCarts().flattenAsObservable { it }
            .flatMapSingle { productCarts ->
                Observable.fromIterable(productCarts.products)
                    .flatMapSingle { product ->
                        productUseCase.getProductById(product.productId)
                    }.toList().map { products -> productCarts to products }
            }.toList().map { pairs ->
                val carts = pairs.map { it.first }
                val products = pairs.flatMap { it.second }
                Pair(carts, products)
            }
    }
}