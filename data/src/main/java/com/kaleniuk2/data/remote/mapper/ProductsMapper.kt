package com.kaleniuk2.data.remote.mapper

import com.kaleniuk2.data.remote.model.CashPayload
import com.kaleniuk2.data.remote.model.ProductPayload
import com.kaleniuk2.data.remote.model.ProductsPayload
import com.kaleniuk2.data.remote.model.SpotlightPayload
import com.kaleniuk2.domain.entities.Product
import com.kaleniuk2.domain.entities.Products

object ProductsMapper {
    fun map(productsPayload: ProductsPayload) : Products =
        Products(
            spotlight = productsPayload.spotlight.map { spotlightPayloadToProduct(it) },
            products = productsPayload.products.map { productPayloadToProduct(it) },
            cash = cashPayloadToProduct(productsPayload.cash)
        )


    private fun spotlightPayloadToProduct(productPayload: SpotlightPayload) = Product(
        productPayload.name,
        productPayload.bannerURL,
        productPayload.description
    )

    private fun cashPayloadToProduct(productPayload: CashPayload) = Product(
        productPayload.title,
        productPayload.bannerURL,
        productPayload.description
    )

    private fun productPayloadToProduct(productPayload: ProductPayload) = Product(
        productPayload.name,
        productPayload.imageURL,
        productPayload.description
    )
}