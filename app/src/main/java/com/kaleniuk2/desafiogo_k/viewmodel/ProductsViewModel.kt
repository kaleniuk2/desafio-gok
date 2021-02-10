package com.kaleniuk2.desafiogo_k.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kaleniuk2.domain.usecases.GetProductUseCase
import com.kaleniuk2.domain.wrapper.ResultWrapper
import kotlinx.coroutines.launch

class ProductsViewModel(
    private val productsUseCase: GetProductUseCase
) : ViewModel() {

    fun getProducts() {
        viewModelScope.launch {
            when (val result = productsUseCase.execute()) {
                is ResultWrapper.Success -> {
                    Log.d("RESULTTT", result.value.toString())
                }
                is ResultWrapper.Error -> {
                    Log.d("RESULTTT", result.error?.message.toString())
                }
            }
        }
    }
}