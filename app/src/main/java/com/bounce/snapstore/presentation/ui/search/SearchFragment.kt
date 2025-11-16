package com.bounce.snapstore.presentation.ui.search

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
import com.bounce.snapstore.databinding.FragmentSearchBinding
import com.bounce.snapstore.utils.NetworkHelper
import com.bounce.snapstore.domain.model.ProductData
import com.bounce.snapstore.presentation.adapter.ProductAdapter
import javax.inject.Inject

class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var searchViewModel: SearchViewModel
    private lateinit var adapter: ProductAdapter
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (activity?.application as MyApplication).networkComponent.inject(this)
        _binding = FragmentSearchBinding.inflate(inflater, container, false)

        ViewCompat.setOnApplyWindowInsetsListener(binding.searchScreenLinearLayout) { view, insets ->

            val systemBarInsets =
                insets.getInsets(WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.displayCutout())

            view.setPadding(
                systemBarInsets.left,
                systemBarInsets.top,
                systemBarInsets.right,
                systemBarInsets.bottom,
            )

            binding.searchView.updateLayoutParams<MarginLayoutParams> {
                topMargin = systemBarInsets.top
            }

            view.updateLayoutParams<MarginLayoutParams> {
                bottomMargin = systemBarInsets.bottom + (systemBarInsets.bottom / 2)
            }
            insets
        }

        searchViewModel = ViewModelProvider(this, viewModelFactory)[SearchViewModel::class.java]

        searchViewModel.getProductsLiveData().observe(viewLifecycleOwner) {

            when {
                it.isSuccess -> {
                    adapter = ProductAdapter(it.getOrNull() ?: emptyList(), itemClickListener)
                    binding.apply {
                        searchScreenNestedScrollView.isVisible = true
                        searchView.isVisible = true
                        progress.isVisible = false
                        searchProductsRv.adapter = adapter
                    }
                }

                it.isFailure -> {
                    if (!NetworkHelper.isNetworkConnected(requireContext())) {
                        binding.apply {
                            searchScreenNestedScrollView.isVisible = true
                            progress.isVisible = false
                            Toast.makeText(
                                requireContext(),
                                "${it.exceptionOrNull()?.message}",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        findNavController().navigate(R.id.navigation_failure)
                    }
                }
            }
        }

        return binding.root
    }

    private val itemClickListener = object : ProductAdapter.ItemClickListener {
        override fun onClick(productData: ProductData) {
            val b = Bundle()
            b.putInt("product_id", productData.id)
            findNavController().navigate(R.id.navigation_product, b)
        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onResume() {
        super.onResume()
        searchViewModel.fetchAllProducts()
    }
}