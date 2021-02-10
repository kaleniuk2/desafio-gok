package com.kaleniuk2.desafiogo_k.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kaleniuk2.desafiogo_k.databinding.ItemSpotlightBinding
import com.kaleniuk2.domain.entities.Product
import com.squareup.picasso.Picasso

class SpotlightAdapter(private val spotlightList: List<Product>) : RecyclerView.Adapter<SpotlightViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpotlightViewHolder {
        return SpotlightViewHolder(
            ItemSpotlightBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: SpotlightViewHolder, position: Int) {
        holder.binding(spotlightList[position])
    }

    override fun getItemCount() = spotlightList.size
}

class SpotlightViewHolder(private val spotlightView: ItemSpotlightBinding) : RecyclerView.ViewHolder(spotlightView.root) {
    fun binding(spotlight: Product) {
        Picasso.get()
            .load(spotlight.imageUrl)
            .into(spotlightView.ivSpotlight)
    }
}