package com.bounce.snapstore.presentation.ui.carts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.MarginLayoutParams
import android.widget.Toast
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.core.view.updateLayoutParams
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bounce.snapstore.MyApplication
import com.bounce.snapstore.R
import com.bounce.snapstore.databinding.FragmentCartsBinding
import com.bounce.snapstore.domain.NetworkHelper
import com.bounce.snapstore.domain.model.ProductData
import com.bounce.snapstore.presentation.adapter.CartsAdapter
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import javax.inject.Inject


class CartsFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var cartsViewModel: CartsViewModel
    private lateinit var binding: FragmentCartsBinding
    private lateinit var cartsAdapter: CartsAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (requireActivity().application as MyApplication).networkComponent.inject(this)
        binding = FragmentCartsBinding.inflate(inflater, container, false)

        ViewCompat.setOnApplyWindowInsetsListener(binding.cartsMainLayout) { view, insets ->

            val systemBarInsets =
                insets.getInsets(WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.displayCutout())

            view.setPadding(
                systemBarInsets.left,
                systemBarInsets.top,
                systemBarInsets.right,
                systemBarInsets.bottom,
            )

            view.updateLayoutParams<MarginLayoutParams> {
                bottomMargin = systemBarInsets.bottom + (systemBarInsets.bottom / 2)
            }
            insets
        }

        cartsViewModel = ViewModelProvider(this, viewModelFactory)[CartsViewModel::class.java]


        binding.buyNowBtn.setOnClickListener {
            Snackbar.make(it, "This app for test", Snackbar.LENGTH_SHORT).setAnimationMode(
                BaseTransientBottomBar.ANIMATION_MODE_SLIDE
            ).show()
        }

        cartsViewModel.getProductsLiveData().observe(viewLifecycleOwner) {

            when {

                it.isSuccess -> {
                    binding.progress.isVisible = false
                    binding.cartsMainLayout.isVisible = true
                    cartsAdapter = CartsAdapter(it.getOrNull()!!, itemClickListener)
                    binding.productCartsRv.adapter = cartsAdapter
                    binding.commonPriceTv.text = "$${cartsAdapter.getTotalPrice()}"
                }

                it.isFailure -> {
                    if (!NetworkHelper.isNetworkConnected(requireContext())) {
                        Toast.makeText(
                            requireContext(),
                            "Something went wrong ${it.exceptionOrNull()?.message}",
                            Toast.LENGTH_SHORT
                        ).show()
                        binding.progress.isVisible = false
                        binding.cartsMainLayout.isVisible = true
                        findNavController().navigate(R.id.navigation_failure)
                    }
                }

            }
        }




        return binding.root
    }

    private val itemClickListener = object : CartsAdapter.ItemClickListener {
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