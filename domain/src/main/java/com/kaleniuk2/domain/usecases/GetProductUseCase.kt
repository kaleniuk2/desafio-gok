package com.kaleniuk2.domain.usecases

import com.kaleniuk2.domain.entities.Products
import com.kaleniuk2.domain.repository.ProductRepository
import com.kaleniuk2.domain.wrapper.ResultWrapper

class GetProductUseCase(
    private val repository: ProductRepository
) {
    suspend fun execute() : ResultWrapper<Products> {
        return repository.getProducts()
    }
}