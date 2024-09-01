package com.bounce.snapstore.presentation.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bounce.snapstore.domain.model.ProductData
import com.bounce.snapstore.domain.usecase.ProductUseCase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class HomeViewModel @Inject constructor(val productUseCase: ProductUseCase) : ViewModel() {
    private val TAG = "HomeViewModel"
    private val productsLiveData = MutableLiveData<Result<List<ProductData>>>()
    private val filterProductsLiveData = MutableLiveData<List<ProductData>>()

    init {
        fetchHomeData()
    }

    fun fetchHomeData() {
        val d = productUseCase.getProducts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                productsLiveData.postValue(Result.success(it))
            }, {
                productsLiveData.postValue(Result.failure(it))
            })
    }

    fun getProductsLiveData(): LiveData<Result<List<ProductData>>> {
        return productsLiveData
    }

    fun filteredProducts(categoryName: String): LiveData<List<ProductData>> {
        filterProductsLiveData.postValue(
            productsLiveData.value?.getOrNull()?.filter { it.category.equals(categoryName) })
        return filterProductsLiveData
    }
}