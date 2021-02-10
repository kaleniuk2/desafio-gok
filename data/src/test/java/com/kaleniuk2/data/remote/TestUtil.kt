package com.kaleniuk2.data.remote

import com.kaleniuk2.data.remote.model.CashPayload
import com.kaleniuk2.data.remote.model.ProductPayload
import com.kaleniuk2.data.remote.model.ProductsPayload
import com.kaleniuk2.data.remote.model.SpotlightPayload
import com.kaleniuk2.domain.entities.Product
import com.kaleniuk2.domain.entities.Products

fun createMockPayload() = ProductsPayload(
    listOf(SpotlightPayload("name", "bannerURL", "description")),
    listOf(ProductPayload("name", "imageURL", "description")),
    CashPayload("title", "bannerURL", "description")
)

fun createExpectedProducts() = Products(
    listOf(Product("name", "bannerURL", "description")),
    listOf(Product("name", "imageURL", "description")),
    Product("title", "bannerURL", "description")
)