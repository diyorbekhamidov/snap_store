package com.bounce.snapstore.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bounce.snapstore.R
import com.bounce.snapstore.domain.model.CategoryData
import com.bounce.snapstore.databinding.CategoryViewBinding

class CategoryAdapter(
    private val categoryList: List<CategoryData>,
    private val categoryClickListener: CategoryClickListener
) :
    RecyclerView.Adapter<CategoryAdapter.Vh>() {


    inner class Vh(private val binding: CategoryViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(position: Int) {

            binding.root.setOnClickListener {
                categoryClickListener.onClick(categoryList[position])
                for (i in categoryList.indices) {
                    categoryList[i].isSelected = false
                }
                categoryList[position].isSelected = true
                notifyDataSetChanged()
            }

            binding.apply {

                if (categoryList[position].isSelected == true) {
                    categoryCard.setBackgroundColor(
                        ContextCompat.getColor(
                            binding.root.context,
                            R.color.purple_500
                        )
                    )
                } else {
                    categoryCard.setBackgroundColor(
                        ContextCompat.getColor(
                            binding.root.context,
                            R.color.light_gray
                        )
                    )
                }

                when (categoryList[position].category) {
                    "all" -> {
                        categoryImg.setImageDrawable(
                            ContextCompat.getDrawable(
                                binding.root.context,
                                R.drawable.all_icon
                            )
                        )

                        titleCategory.text = categoryList[position].category
                    }

                    "electronics" -> {
                        categoryImg.setImageDrawable(
                            ContextCompat.getDrawable(
                                binding.root.context,
                                R.drawable.electro_icon
                            )
                        )
                        titleCategory.text = categoryList[position].category
                    }

                    "jewelery" -> {
                        categoryImg.setImageDrawable(
                            ContextCompat.getDrawable(
                                binding.root.context,
                                R.drawable.jewel_icon
                            )
                        )
                        titleCategory.text = categoryList[position].category
                    }

                    "men's clothing" -> {
                        categoryImg.setImageDrawable(
                            ContextCompat.getDrawable(
                                binding.root.context,
                                R.drawable.men
                            )
                        )
                        titleCategory.text = categoryList[position].category

                    }

                    "women's clothing" -> {
                        categoryImg.setImageDrawable(
                            ContextCompat.getDrawable(
                                binding.root.context,
                                R.drawable.women_icon
                            )
                        )
                        titleCategory.text = categoryList[position].category
                    }
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(CategoryViewBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = categoryList.size

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(position)
    }

    interface CategoryClickListener {
        fun onClick(categoryData: CategoryData)
    }
}