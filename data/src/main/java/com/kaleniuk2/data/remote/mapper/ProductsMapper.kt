package com.kaleniuk2.data.remote.mapper

import com.kaleniuk2.data.remote.model.ProductPayload
import com.kaleniuk2.data.remote.model.ProductsPayload
import com.kaleniuk2.domain.entities.Product
import com.kaleniuk2.domain.entities.Products

object ProductsMapper {
    fun map(productsPayload: ProductsPayload) : Products =
        Products(
            spotlight = productsPayload.spotlight.map { payloadToProduct(it) },
            products = productsPayload.products.map { payloadToProduct(it) },
            cash = payloadToProduct(productsPayload.cash)
        )


    private fun payloadToProduct(productPayload: ProductPayload) = Product(
        productPayload.name,
        productPayload.bannerURL,
        productPayload.description
    )
}