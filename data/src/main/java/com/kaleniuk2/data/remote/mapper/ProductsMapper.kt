package com.kaleniuk2.data.remote.mapper

import com.kaleniuk2.data.remote.ProductPayload
import com.kaleniuk2.data.remote.ProductsPayload
import com.kaleniuk2.domain.entities.Product
import com.kaleniuk2.domain.entities.Products

object ProductsMapper {
    fun map(productsPayload: ProductsPayload) : Products =
        Products(
            spotlight = productsPayload.spotlight.map { payloadToProduct(it) },
            products = productsPayload.products.map { payloadToProduct(it) },
            cash = productsPayload.cash.map { payloadToProduct(it) }
        )


    private fun payloadToProduct(productPayload: ProductPayload) = Product(
        productPayload.name,
        productPayload.bannerURL,
        productPayload.description
    )
}