package com.bounce.snapstore.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bounce.snapstore.databinding.ProductCartsViewBinding
import com.bounce.snapstore.domain.model.ProductCartData
import com.bounce.snapstore.domain.model.ProductData
import com.bumptech.glide.Glide

class CartsAdapter(
    private val cartsList: Pair<List<ProductCartData>, List<ProductData>>,
    val itemCLickListener: ItemClickListener
) :
    RecyclerView.Adapter<CartsAdapter.Vh>() {

    private val productList = cartsList.second.distinct()

    inner class Vh(val binding: ProductCartsViewBinding) : RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun onBind(position: Int) {

            val productData = productList[position]
            binding.apply {
                Glide.with(binding.root).load(productData.image).into(productCartsImg)
                productCartsTitleTv.text = productData.title
                productCartsPriceTv.text = "$${getCurrentProductPrice(productData)}"
                quantityProductTv.text = "${getCurrentProductQuantity(productData)}"

            }
        }

        fun quantityChange(position: Int) {
            val productData = productList[position]

            binding.minusProductTv.setOnClickListener {
                binding.quantityProductTv.text = "${getCurrentProductQuantity(productData) - 1}"
                notifyItemChanged(position)
            }

            binding.plusProductTv.setOnClickListener {
                binding.quantityProductTv.text = "${getCurrentProductQuantity(productData) + 1}"
                notifyItemChanged(position)
            }

        }

        private fun getCurrentProductPrice(productData: ProductData): Double {
            return productData.price * getCurrentProductQuantity(productData)
        }

        private fun getCurrentProductQuantity(productData: ProductData): Int {
            var q = 0
            cartsList.first.forEach {
                it.products.forEach {
                    if (it.productId == productData.id) {
                        q = it.quantity
                    }
                }
            }
            return q
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(
            ProductCartsViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = productList.size

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(position)
        holder.quantityChange(position)
        holder.binding.root.setOnClickListener {
            itemCLickListener.onClick(productList[position])
        }
    }

    interface ItemClickListener {
        fun onClick(productData: ProductData)
    }


    fun getTotalPrice(): Double {
        var price = 0.0

        cartsList.first.forEach {
            it.products.forEach {
                for (productData in productList) {
                    if (it.productId == productData.id) {
                        price += (productData.price * it.quantity)
                    }
                }
            }
        }
        return price
    }
}