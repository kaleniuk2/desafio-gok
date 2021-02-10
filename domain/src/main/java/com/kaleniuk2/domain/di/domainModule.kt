package com.kaleniuk2.domain.di

import com.kaleniuk2.domain.usecases.GetProductUseCase
import org.koin.dsl.module.module

val domainModule = module {
    factory {
        GetProductUseCase(get())
    }
}