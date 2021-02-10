package com.kaleniuk2.data.remote.mapper

import com.kaleniuk2.data.remote.createExpectedProducts
import com.kaleniuk2.data.remote.createMockPayload
import junit.framework.Assert.assertEquals
import org.junit.Test

class ProductsMapperTest {

    @Test
    fun `given Payload Object then Convert this Object in Entitie Domain`() {
        //arrange
        val mockPayload = createMockPayload()
        val expectedResult = createExpectedProducts()

        //act
        val products = ProductsMapper.map(mockPayload)

        //assert
        assertEquals(expectedResult, products)
    }
}