package com.kaleniuk2.domain.usecases

import com.kaleniuk2.domain.entities.Products
import com.kaleniuk2.domain.repository.ProductRepository

class GetProductUseCase(
    private val repository: ProductRepository
) {
    suspend fun execute() : Products {
        return repository.getProducts()
    }
}