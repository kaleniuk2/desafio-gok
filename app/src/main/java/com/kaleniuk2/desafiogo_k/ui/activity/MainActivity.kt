package com.kaleniuk2.desafiogo_k.ui.activity

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.kaleniuk2.desafiogo_k.R
import com.kaleniuk2.desafiogo_k.databinding.ActivityMainBinding
import com.kaleniuk2.desafiogo_k.extension.showToast
import com.kaleniuk2.desafiogo_k.state.MainActivityState
import com.kaleniuk2.desafiogo_k.ui.adapter.ProductsAdapter
import com.kaleniuk2.desafiogo_k.ui.adapter.SpotlightAdapter
import com.kaleniuk2.desafiogo_k.viewmodel.ProductsViewModel
import com.kaleniuk2.domain.entities.Product
import com.squareup.picasso.Picasso
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val productsViewModel: ProductsViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupViewBinding()
        setupToolbar()
        setupObservers()
        getProducts()
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.mainToolbar)
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
                    setupSpotlightViewPager(mainState.products.spotlight)
                    setupCash(mainState.products.cash)
                    setupProducts(mainState.products.products)
                }
                is MainActivityState.Error -> {
                    createTryAgainDialog(mainState.error)
                }
                is MainActivityState.ShowLoading -> {
                    showLoading(mainState.show)
                }
            }
        }
    }

    private fun showLoading(show: Boolean) {
        binding.mainProgress.visibility = if (show) { View.VISIBLE } else { View.GONE }
    }

    private fun setupProducts(products: List<Product>) {
        binding.rvMainProducts.apply {
            adapter = ProductsAdapter(products)
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
        }
    }

    private fun setupCash(cash: Product) {
        Picasso.get()
            .load(cash.imageUrl)
            .into(binding.ivMainCash)
    }

    private fun setupSpotlightViewPager(spotlightList: List<Product>) {
        binding.vpMainSpotlight.apply {
            adapter = SpotlightAdapter(spotlightList)
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
            offscreenPageLimit = 3
            setPageTransformer(MarginPageTransformer(resources.getDimension(R.dimen._10sdp).toInt()))
        }
    }

    private fun createTryAgainDialog(errorMessage: String) {
        AlertDialog
            .Builder(this)
            .setTitle(R.string.loading_error)
            .setMessage(errorMessage)
            .setPositiveButton(R.string.try_again
            ) { dialog, _ ->
                productsViewModel.getProducts()
                dialog.dismiss()
            }
            .setNegativeButton(R.string.exit_app) { _, _ ->
                finish()
            }
            .create()
            .show()
    }
}