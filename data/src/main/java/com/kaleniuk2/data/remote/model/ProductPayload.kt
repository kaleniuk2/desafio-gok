package com.kaleniuk2.data.remote

data class ProductsPayload(
    var spotlight: List<ProductPayload> = listOf(),
    var products: List<ProductPayload> = listOf(),
    var cash: List<ProductPayload> = listOf()
)

data class ProductPayload(
    var name: String = "",
    var bannerURL: String = "",
    var description: String = ""
)

