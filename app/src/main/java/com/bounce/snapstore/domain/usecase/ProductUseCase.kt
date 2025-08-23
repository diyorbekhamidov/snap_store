package com.bounce.snapstore.domain.usecase

import com.bounce.snapstore.domain.repository.ProductRepository
import javax.inject.Inject

class ProductUseCase @Inject constructor(private val productRepository: ProductRepository) {
    fun getProducts() = productRepository.getAllProducts()

    fun getProductById(id: Int) = productRepository.getProductById(id)
}