package com.kaleniuk2.desafiogo_k.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kaleniuk2.desafiogo_k.R
import com.kaleniuk2.desafiogo_k.viewmodel.ProductsViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val productsViewModel: ProductsViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        productsViewModel.getProducts()
    }
}