package com.bounce.snapstore.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bounce.snapstore.databinding.ProductViewBinding
import com.bounce.snapstore.domain.model.ProductData
import com.bumptech.glide.Glide

class ProductAdapter(private var productList: List<ProductData>, private val itemClickListener: ItemClickListener) :
    RecyclerView.Adapter<ProductAdapter.Vh>() {


    inner class Vh(private val binding: ProductViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun onBind(position: Int) {
            val product = productList[position]

            binding.apply {
                Glide.with(binding.root).load(product.image).into(imgProduct)
                productTitle.text = product.title
                productPrice.text = " $${product.price}"
                productRating.text = product.rating.rate.toString()

            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ProductViewBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(position)
        holder.itemView.setOnClickListener {
            itemClickListener.onClick(productList[position])
        }
    }

    fun filteredList(filterList: List<ProductData>) {
        productList = filterList
        notifyDataSetChanged()
    }

    interface ItemClickListener{
        fun onClick(productData: ProductData)
    }
}