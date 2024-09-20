package com.bounce.snapstore.presentation.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.bounce.snapstore.MyApplication
import com.bounce.snapstore.R
import com.bounce.snapstore.databinding.FragmentHomeBinding
import com.bounce.snapstore.domain.NetworkHelper
import com.bounce.snapstore.domain.model.CategoryData
import com.bounce.snapstore.domain.model.ProductData
import com.bounce.snapstore.domain.model.SalesData
import com.bounce.snapstore.presentation.adapter.CategoryAdapter
import com.bounce.snapstore.presentation.adapter.ProductAdapter
import com.bounce.snapstore.presentation.adapter.SalesPagerAdapter
import com.bounce.snapstore.presentation.vm.HomeViewModel
import javax.inject.Inject

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    val salesList = listOf(
        SalesData("30% OFF ON FIRST ORDER", R.drawable.shop1, R.color.purple_200),
        SalesData("15% OFF DURING THE WEEKEND", R.drawable.shop2, R.color.teal_700),
        SalesData("20% OFF ON SECOND ORDER", R.drawable.shop3, R.color.purple_500)
    )

    val categoryList = listOf(
        CategoryData("all", true),
        CategoryData("electronics", false),
        CategoryData("jewelery", false),
        CategoryData("men's clothing", false),
        CategoryData("women's clothing", false)
    )

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var homeViewModel: HomeViewModel
    private lateinit var productAdapter: ProductAdapter
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        (requireActivity().application as MyApplication).networkComponent.inject(this)
        homeViewModel = ViewModelProvider(this, viewModelFactory)[HomeViewModel::class.java]
        binding.salesViewPager.adapter = SalesPagerAdapter(salesList, salesClickListener)

        binding.categoryRv.adapter =
            CategoryAdapter(categoryList, object : CategoryAdapter.CategoryClickListener {
                override fun onClick(categoryData: CategoryData) {
                    if (categoryData.category.equals("all")) {
                        productAdapter.filteredList(
                            homeViewModel.getProductsLiveData().value?.getOrNull() ?: emptyList()
                        )
                    } else {
                        homeViewModel.filteredProducts(categoryData.category)
                            .observe(viewLifecycleOwner) {
                                productAdapter.filteredList(it)
                            }
                    }
                }
            })

        homeViewModel.getProductsLiveData().observe(viewLifecycleOwner) {
            setDataToUI(it)
        }

        binding.salesViewPager.apply {
            offscreenPageLimit = 3
            clipToPadding = false
            clipChildren = false
            setPadding(0, 0, 100, 0)
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    if (position == 0) {
                        setPadding(0, 0, 100, 0) // Add padding to show partial next/previous item
                    } else if (position >= salesList.size - 1) {
                        setPadding(100, 0, 0, 0)
                    }
                    super.onPageSelected(position)
                }

            })

        }



        return root
    }

    private fun setDataToUI(it: Result<List<ProductData>>) {
        when {
            it.isSuccess -> {
                binding.apply {
                    productAdapter =
                        ProductAdapter(it.getOrNull() ?: emptyList(), productItemClickListener)
                    productsRv.adapter = productAdapter
                    progressProducts.isVisible = false
                    homeMainLayout.isVisible = true
                }
            }

            it.isFailure -> {
                if (!NetworkHelper.isConnected(requireContext())) {
                    binding.apply {
                        progressProducts.isVisible = false
                        homeMainLayout.isVisible = true
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

    private val productItemClickListener = object : ProductAdapter.ItemClickListener {
        override fun onClick(productData: ProductData) {
            val b = Bundle()
            val id = productData.id
            b.putInt("product_id", id)
            findNavController().navigate(R.id.navigation_product, b)
        }
    }

    private val salesClickListener = object : SalesPagerAdapter.ItemClickListener {
        override fun onClick(position: Int) {
            val b = Bundle()
            b.putInt("product_id", position + 1)
            findNavController().navigate(R.id.navigation_product, b)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onResume() {
        super.onResume()
        homeViewModel.fetchHomeData()
    }
}