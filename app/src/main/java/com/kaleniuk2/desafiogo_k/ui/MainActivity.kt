package com.kaleniuk2.desafiogo_k.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kaleniuk2.desafiogo_k.R
import com.kaleniuk2.desafiogo_k.databinding.ActivityMainBinding
import com.kaleniuk2.desafiogo_k.extension.showToast
import com.kaleniuk2.desafiogo_k.state.MainActivityState
import com.kaleniuk2.desafiogo_k.viewmodel.ProductsViewModel
import org.koin.android.scope.ext.android.getOrCreateScope
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val productsViewModel: ProductsViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupViewBinding()
        setupObservers()
        getProducts()
    }

    private fun setupViewBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun getProducts() {
        productsViewModel.getProducts()
    }

    private fun setupObservers() {
        productsViewModel.mainState.observe(this) { mainState ->
            when (mainState) {
                is MainActivityState.Success -> {

                }
                is MainActivityState.Error -> {
                    showToast(mainState.error)
                }
            }
        }
    }
}