package com.kaleniuk2.data

import com.kaleniuk2.data.remote.RemoteDataSource
import com.kaleniuk2.data.remote.createExpectedProducts
import com.kaleniuk2.data.remote.createMockPayload
import com.kaleniuk2.data.remote.model.ProductsPayload
import com.kaleniuk2.domain.wrapper.ResultWrapper
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Test

class ProductRepositoryTest {

    @Test
    fun `given Api Returns Error Should Return Error Object`() {
        val exception = Exception("error")
        val expectedResult = ResultWrapper.Error(exception)
        val remoteDataSourceMock: RemoteDataSource = mockk()
        val repository = ProductRepositoryImpl(remoteDataSourceMock)

        coEvery { remoteDataSourceMock.getProducts() } returns ResultWrapper.Error(exception)
        runBlocking {
            assertEquals(
                expectedResult,
                repository.getProducts()
            )
        }
    }

    @Test
    fun `given Api Returns Success Should Return Success Object`() {
        val successRemote: ProductsPayload = createMockPayload()
        val successRepository = createExpectedProducts()
        val expectedResult = ResultWrapper.Success(successRepository)
        val remoteDataSourceMock: RemoteDataSource = mockk()
        val repository = ProductRepositoryImpl(remoteDataSourceMock)

        coEvery { remoteDataSourceMock.getProducts() } returns ResultWrapper.Success(successRemote)
        runBlocking {
            assertEquals(
                expectedResult,
                repository.getProducts()
            )
        }
    }


}