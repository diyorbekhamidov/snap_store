package com.bounce.snapstore.presentation.ui.product

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bounce.snapstore.MyApplication
import com.bounce.snapstore.R
import com.bounce.snapstore.databinding.FragmentProductBinding
import com.bounce.snapstore.utils.NetworkHelper
import com.bounce.snapstore.domain.model.ProductData
import com.bumptech.glide.Glide
import javax.inject.Inject

class ProductFragment : Fragment() {
    private val TAG = "ProductFragment"
    private var ARG_PARAM1: String = "product_id"
    private var param1: Int? = null
    private lateinit var productData: ProductData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getInt(ARG_PARAM1)
        }
    }

    private lateinit var binding: FragmentProductBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var productViewModel: ProductViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (requireActivity().application as MyApplication).networkComponent.inject(this)
        binding = FragmentProductBinding.inflate(inflater, container, false)

        ViewCompat.setOnApplyWindowInsetsListener(binding.productScreenLinearLayout) { view, insets ->

            val systemBarInsets =
                insets.getInsets(WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.displayCutout())

            view.setPadding(
                systemBarInsets.left,
                systemBarInsets.top,
                systemBarInsets.right,
                systemBarInsets.bottom,
            )
            insets
        }

        productViewModel = ViewModelProvider(this, viewModelFactory)[ProductViewModel::class.java]

        //Back btn
        binding.backBtn.backBtn.setOnClickListener {
            findNavController().popBackStack()
        }

        productViewModel.fetchProductData(param1 ?: 1)
        productViewModel.getProductLiveData().observe(viewLifecycleOwner) {

            binding.apply {
                when {
                    it.isSuccess -> {
                        productData = it.getOrNull()!!
                        setUI(productData)
                        productScreenLinearLayout.isVisible = true
                        productProgress.isVisible = false
                    }

                    it.isFailure -> {
                        if (!NetworkHelper.isNetworkConnected(requireContext())) {
                            binding.apply {
                                productProgress.isVisible = false
                                productScreenLinearLayout.isVisible = true
                                Toast.makeText(
                                    requireContext(),
                                    it.exceptionOrNull()?.message,
                                    Toast.LENGTH_SHORT
                                ).show()
                                findNavController().navigate(R.id.navigation_failure)

                            }
                        }
                    }
                }
            }

            binding.addCardBtn.setOnClickListener {
                findNavController().popBackStack()
            }

        }

        return binding.root
    }

    private fun setUI(productData: ProductData) {

        binding.apply {
            Glide.with(requireContext()).load(productData.image).into(productImage)
            productTitle.text = productData.title
            productDescription.text = productData.price.toString()
            productDescription.text = productData.description
            productRating.text = "${productData.rating.rate}(${productData.rating.count})"
            productPrice.text = "$${productData.price}"

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
        binding.root.removeAllViews()
        param1 = null
    }
}