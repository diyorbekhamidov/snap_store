package com.bounce.snapstore.presentation.ui.search

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
import com.bounce.snapstore.databinding.FragmentSearchBinding
import com.bounce.snapstore.domain.NetworkHelper
import com.bounce.snapstore.domain.model.ProductData
import com.bounce.snapstore.presentation.adapter.ProductAdapter
import com.bounce.snapstore.presentation.vm.SearchViewModel
import javax.inject.Inject

class SearchFragment : Fragment() {

    private var binding: FragmentSearchBinding? = null

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var searchViewModel: SearchViewModel
    private lateinit var adapter: ProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)

        (activity?.application as MyApplication).networkComponent.inject(this)
        searchViewModel = ViewModelProvider(this, viewModelFactory)[SearchViewModel::class.java]

        searchViewModel.getProductsLiveData().observe(viewLifecycleOwner) {

            when {
                it.isSuccess -> {
                    adapter = ProductAdapter(it.getOrNull() ?: emptyList(), itemClickListener)
                    binding?.apply {
                        searchProductsLayout.isVisible = true
                        progress.isVisible = false
                        searchProductsRv.adapter = adapter
                    }
                }

                it.isFailure -> {
                    if (!NetworkHelper.isConnected(requireContext())) {
                        binding?.apply {
                            searchProductsLayout.isVisible = true
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

        return binding!!.root
    }

    val itemClickListener = object : ProductAdapter.ItemClickListener {
        override fun onClick(productData: ProductData) {
            val b = Bundle()
            b.putInt("product_id", productData.id)
            findNavController().navigate(R.id.navigation_product, b)
        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun onResume() {
        super.onResume()
        searchViewModel.fetchAllProducts()
    }
}