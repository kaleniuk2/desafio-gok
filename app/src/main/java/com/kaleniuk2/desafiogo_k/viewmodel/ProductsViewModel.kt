package com.kaleniuk2.desafiogo_k.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kaleniuk2.desafiogo_k.state.MainActivityState
import com.kaleniuk2.domain.entities.Products
import com.kaleniuk2.domain.usecases.GetProductUseCase
import com.kaleniuk2.domain.wrapper.ResultWrapper
import kotlinx.coroutines.launch

class ProductsViewModel(
    private val productsUseCase: GetProductUseCase
) : ViewModel() {

    private val _mainState: MutableLiveData<MainActivityState> = MutableLiveData()
    val mainState: LiveData<MainActivityState> = _mainState

    fun getProducts() {
        viewModelScope.launch {
            when (val result = productsUseCase.execute()) {
                is ResultWrapper.Success -> {
                    _mainState.value = MainActivityState.Success(result.value)
                }
                is ResultWrapper.Error -> {
                    _mainState.value = MainActivityState.Error(result.error?.message.toString())
                }
            }
        }
    }
}