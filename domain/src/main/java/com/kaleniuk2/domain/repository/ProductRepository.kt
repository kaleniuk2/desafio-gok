package com.kaleniuk2.domain.repository

import com.kaleniuk2.domain.entities.Products

interface ProductRepository {
    suspend fun getProducts() : Products
}