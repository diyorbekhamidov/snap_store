package com.bounce.snapstore.domain.usecase

import com.bounce.snapstore.domain.repository.ProductRepository
import javax.inject.Inject

class ProductUseCase @Inject constructor(val productRepository: ProductRepository) {
    fun getProducts() = productRepository.getProducts()

    fun getProductById(id: Int) = productRepository.getProductById(id)
}