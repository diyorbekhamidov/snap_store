package com.bounce.snapstore.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bounce.snapstore.domain.model.SalesData
import com.bounce.snapstore.databinding.SalesPagerViewBinding

class SalesPagerAdapter(private val salesList: List<SalesData>) :
    RecyclerView.Adapter<SalesPagerAdapter.Vh>() {

    inner class Vh(private val binding: SalesPagerViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(position: Int) {
            binding.apply {
                titleSalesTv.text = salesList[position].title
                imgSales.setImageResource(salesList[position].image)
                salesPagerCard.setBackgroundColor(ContextCompat.getColor(binding.root.context, salesList[position].color))
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(SalesPagerViewBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = salesList.size

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(position)
    }
}