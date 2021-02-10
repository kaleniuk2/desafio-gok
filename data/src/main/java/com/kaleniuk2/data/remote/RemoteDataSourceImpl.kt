package com.kaleniuk2.data.remote

import com.kaleniuk2.data.remote.api.ProductsApi
import com.kaleniuk2.data.remote.model.ProductsPayload
import com.kaleniuk2.data.remote.util.safeApiCall
import com.kaleniuk2.domain.wrapper.ResultWrapper

class RemoteDataSourceImpl(private val productsApi: ProductsApi) : RemoteDataSource {
    override suspend fun getProducts(): ResultWrapper<ProductsPayload> {
        return safeApiCall {
            productsApi.getProducts()
        }
    }
}