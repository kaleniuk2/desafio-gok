package com.kaleniuk2.data.remote

import com.kaleniuk2.data.remote.model.ProductsPayload
import com.kaleniuk2.domain.wrapper.ResultWrapper

interface RemoteDataSource {
    suspend fun getProducts(): ResultWrapper<ProductsPayload>
}