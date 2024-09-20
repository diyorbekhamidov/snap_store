package com.bounce.snapstore.presentation.ui.carts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bounce.snapstore.MyApplication
import com.bounce.snapstore.R
import com.bounce.snapstore.databinding.FragmentCartsBinding
import com.bounce.snapstore.domain.NetworkHelper
import com.bounce.snapstore.domain.model.ProductData
import com.bounce.snapstore.presentation.adapter.CartsAdapter
import com.bounce.snapstore.presentation.vm.CartsViewModel
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import javax.inject.Inject


class CartsFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var cartsViewModel: CartsViewModel
    private lateinit var binding: FragmentCartsBinding
    private lateinit var cartsAdapter: CartsAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartsBinding.inflate(inflater, container, false)
        (requireActivity().application as MyApplication).networkComponent.inject(this)
        cartsViewModel = ViewModelProvider(this, viewModelFactory)[CartsViewModel::class.java]


        binding.buyNowBtn.setOnClickListener {
            Snackbar.make(it, "This app for test", Snackbar.LENGTH_SHORT).setAnimationMode(
                BaseTransientBottomBar.ANIMATION_MODE_SLIDE
            ).show()
        }

        cartsViewModel.getProductsLiveData().observe(viewLifecycleOwner) {

            when {

                it.isSuccess -> {
                    binding.progressCarts.isVisible = false
                    binding.cartsMainLayout.isVisible = true
                    cartsAdapter = CartsAdapter(it.getOrNull()!!, itemClickListener)
                    binding.productCartsRv.adapter = cartsAdapter
                    binding.commonPriceTv.text = "$${cartsAdapter.getTotalPrice()}"
                }

                it.isFailure -> {
                    if (!NetworkHelper.isConnected(requireContext())) {
                        Toast.makeText(
                            requireContext(),
                            "Something went wrong ${it.exceptionOrNull()?.message}",
                            Toast.LENGTH_SHORT
                        ).show()
                        binding.progressCarts.isVisible = false
                        binding.cartsMainLayout.isVisible = true
                        findNavController().navigate(R.id.navigation_failure)
                    }
                }

            }
        }




        return binding.root
    }

    val itemClickListener = object : CartsAdapter.ItemClickListener {
        override fun onClick(productData: ProductData) {
            val b = Bundle()
            b.putInt("product_id", productData.id)
            findNavController().navigate(R.id.navigation_product, b)
        }

    }

    override fun onResume() {
        super.onResume()
        cartsViewModel.fetchAllCarts()
    }


}