package com.kaleniuk2.data.remote.model

data class ProductsPayload(
    var spotlight: List<SpotlightPayload> = listOf(),
    var products: List<ProductPayload> = listOf(),
    var cash: CashPayload
)

data class ProductPayload(
    var name: String = "",
    var imageURL: String = "",
    var description: String = ""
)

data class CashPayload(
    var title: String = "",
    var bannerURL: String = "",
    var description: String = ""
)

data class SpotlightPayload(
    var name: String = "",
    var bannerURL: String = "",
    var description: String = ""
)

