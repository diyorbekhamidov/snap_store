package com.bounce.snapstore.presentation.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bounce.snapstore.domain.model.ProductData
import com.bounce.snapstore.domain.usecase.ProductUseCase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class SearchViewModel @Inject constructor(val productUseCase: ProductUseCase) : ViewModel() {

    private val productsLiveData = MutableLiveData<Result<List<ProductData>>>()

    init {
        fetchAllProducts()
    }

     fun fetchAllProducts() {

        val d = productUseCase.getProducts().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                productsLiveData.postValue(Result.success(it))
            },{
                productsLiveData.postValue(Result.failure(it))
            })
    }

    fun getProductsLiveData() = productsLiveData
}