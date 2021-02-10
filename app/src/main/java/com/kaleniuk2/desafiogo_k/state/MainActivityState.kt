package com.kaleniuk2.desafiogo_k.state

import com.kaleniuk2.domain.entities.Products

sealed class MainActivityState {
    class Success(val products: Products): MainActivityState()
    object Error: MainActivityState()
}