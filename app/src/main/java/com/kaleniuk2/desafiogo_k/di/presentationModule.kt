package com.kaleniuk2.desafiogo_k.di

import com.kaleniuk2.desafiogo_k.viewmodel.ProductsViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val presentationModule = module {
    viewModel { ProductsViewModel(get()) }
}