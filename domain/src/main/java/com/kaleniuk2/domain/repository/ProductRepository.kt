package com.kaleniuk2.domain.repository

import com.kaleniuk2.domain.entities.Products
import com.kaleniuk2.domain.wrapper.ResultWrapper

interface ProductRepository {
    suspend fun getProducts() : ResultWrapper<Products>
}