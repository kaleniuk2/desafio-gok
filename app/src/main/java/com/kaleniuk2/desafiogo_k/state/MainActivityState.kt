package com.kaleniuk2.desafiogo_k.state

import com.kaleniuk2.domain.entities.Products

sealed class MainActivityState {
    data class Success(val products: Products): MainActivityState()
    data class Error(val error: String): MainActivityState()
    object ShowLoading: MainActivityState()
    object HideLoading: MainActivityState()
}