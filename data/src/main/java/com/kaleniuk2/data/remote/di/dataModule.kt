package com.kaleniuk2.data.remote.di

import com.kaleniuk2.data.ProductRepositoryImpl
import com.kaleniuk2.domain.repository.ProductRepository
import org.koin.dsl.module.module

val repositoryModule = module {
    factory<ProductRepository> {
        ProductRepositoryImpl(
            get()
        )
    }
}

val dataModules = listOf(remoteDataModule, repositoryModule)