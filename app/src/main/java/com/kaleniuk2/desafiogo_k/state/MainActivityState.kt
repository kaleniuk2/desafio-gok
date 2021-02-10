package com.kaleniuk2.desafiogo_k.state

import com.kaleniuk2.domain.entities.Products

sealed class MainActivityState {
    class Success(val products: Products): MainActivityState()
    class Error(val error: String): MainActivityState()
    class ShowLoading(val show: Boolean): MainActivityState()
}