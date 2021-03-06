package com.kaleniuk2.data.remote.di

import com.kaleniuk2.data.BuildConfig
import com.kaleniuk2.data.remote.RemoteDataSource
import com.kaleniuk2.data.remote.RemoteDataSourceImpl
import com.kaleniuk2.data.remote.api.ProductsApi
import okhttp3.OkHttpClient
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val remoteDataModule = module {
    factory { providesOkHttpClient() }
    single {
        createWebService<ProductsApi>(
            get(),
            BuildConfig.BASE_URL
        )
    }

    factory<RemoteDataSource> { RemoteDataSourceImpl(get()) }
}

fun providesOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()
}

inline fun <reified T> createWebService(okHttpClient: OkHttpClient , url: String): T {
    return Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(url)
        .client(okHttpClient)
        .build()
        .create(T::class.java)
}