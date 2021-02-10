package com.kaleniuk2.data.remote.api

import com.kaleniuk2.data.remote.model.ProductsPayload
import retrofit2.http.GET

interface ProductsApi {
    @GET("products")
    suspend fun getProducts(): ProductsPayload
}