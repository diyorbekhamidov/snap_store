package com.bounce.snapstore.presentation.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bounce.snapstore.domain.model.ProductData
import com.bounce.snapstore.domain.usecase.ProductUseCase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class ProductViewModel @Inject constructor(val productUseCase: ProductUseCase) : ViewModel() {

    private val productLiveData = MutableLiveData<Result<ProductData>>()


    fun fetchProductData(id: Int) {
        val d = productUseCase.getProductById(id).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                productLiveData.postValue(Result.success(it))
            }, {
                productLiveData.postValue(Result.failure(it))
            })
    }

    fun getProductLiveData() = productLiveData
}