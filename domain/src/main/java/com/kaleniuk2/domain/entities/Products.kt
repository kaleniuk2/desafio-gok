package com.kaleniuk2.domain.entities

data class Products(
    var spotlight: List<Product> = listOf(),
    var products: List<Product> = listOf(),
    var cash: List<Product> = listOf()
)
