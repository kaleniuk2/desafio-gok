package com.kaleniuk2.desafiogo_k.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.kaleniuk2.desafiogo_k.createMockProducts
import com.kaleniuk2.desafiogo_k.state.MainActivityState
import com.kaleniuk2.domain.usecases.GetProductUseCase
import com.kaleniuk2.domain.wrapper.ResultWrapper
import io.mockk.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.lang.Exception


@ExperimentalCoroutinesApi
class ProductsViewModelTest {
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()


    var stateObserver: Observer<MainActivityState> = mockk(relaxed = true)

    private val testDispatcher  = TestCoroutineDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        MockKAnnotations.init(this)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }

    @Test
    fun `given Request Success Should Return State Object Success`() {
        val mockUseCase: GetProductUseCase = mockk()
        coEvery { mockUseCase.execute() } returns  ResultWrapper.Success(createMockProducts())
        val mockProducts = createMockProducts()

        val productsViewModel = ProductsViewModel(mockUseCase)
        productsViewModel.mainState.observeForever(stateObserver)

        productsViewModel.getProducts()

        verify(exactly = 1) { stateObserver.onChanged(MainActivityState.ShowLoading) }
        verify(exactly = 1) { stateObserver.onChanged(MainActivityState.HideLoading) }
        verify(exactly = 1) { stateObserver.onChanged(MainActivityState.Success(mockProducts)) }
    }

    @Test
    fun `given Request Failure Should Return State Object Failure`() {
        val mockUseCase: GetProductUseCase = mockk()
        coEvery { mockUseCase.execute() } returns  ResultWrapper.Error(Exception("error"))


        val productsViewModel = ProductsViewModel(mockUseCase)
        productsViewModel.mainState.observeForever(stateObserver)

        productsViewModel.getProducts()

        verify(exactly = 1) { stateObserver.onChanged(MainActivityState.ShowLoading) }
        verify(exactly = 1) { stateObserver.onChanged(MainActivityState.HideLoading) }
        verify(exactly = 1) { stateObserver.onChanged(MainActivityState.Error("error")) }
    }
}