package com.kaleniuk2.data

import com.kaleniuk2.data.remote.RemoteDataSource
import com.kaleniuk2.data.remote.mapper.ProductsMapper
import com.kaleniuk2.domain.entities.Products
import com.kaleniuk2.domain.repository.ProductRepository
import com.kaleniuk2.domain.wrapper.ResultWrapper

class ProductRepositoryImpl(private val remoteDataSource: RemoteDataSource): ProductRepository {
    override suspend fun getProducts(): ResultWrapper<Products> {
        return when(val data = remoteDataSource.getProducts()) {
            is ResultWrapper.Success -> {
                ResultWrapper.Success(
                    ProductsMapper.map(data.value)
                )
            }
            is ResultWrapper.Error -> {
                data
            }
        }
    }
}