package com.kaleniuk2.desafiogo_k.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kaleniuk2.desafiogo_k.databinding.ItemProductsBinding
import com.kaleniuk2.domain.entities.Product
import com.squareup.picasso.Picasso

class ProductsAdapter(private val productsList: List<Product>) : RecyclerView.Adapter<ProductsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        return ProductsViewHolder(
            ItemProductsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        holder.binding(productsList[position])
    }

    override fun getItemCount() = productsList.size
}

class ProductsViewHolder(private val productsView: ItemProductsBinding) : RecyclerView.ViewHolder(productsView.root) {
    fun binding(product: Product) {
        Picasso.get()
            .load(product.imageUrl)
            .into(productsView.ivProducts)
    }
}