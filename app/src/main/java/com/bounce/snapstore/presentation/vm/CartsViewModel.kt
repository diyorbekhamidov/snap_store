package com.bounce.snapstore.presentation.vm

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bounce.snapstore.domain.model.ProductCartData
import com.bounce.snapstore.domain.model.ProductData
import com.bounce.snapstore.domain.usecase.CartsUseCase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class CartsViewModel @Inject constructor(
    val cartsUseCase: CartsUseCase
) : ViewModel() {

    private val TAG = "CartsViewModel"
    private val productCartsLiveData =
        MutableLiveData<Result<Pair<List<ProductCartData>, List<ProductData>>>>()

    init {
        fetchAllCarts()
    }

     fun fetchAllCarts() {
        Log.d(TAG, "fetchAllCarts: ")
        val d = cartsUseCase.getCarts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                productCartsLiveData.postValue(Result.success(it))
            }, {
                productCartsLiveData.postValue(Result.failure(it))
            })
    }

    fun getProductsLiveData() = productCartsLiveData

}