package com.bounce.snapstore.di.component

import com.bounce.snapstore.di.module.NetworkModule
import com.bounce.snapstore.presentation.ui.carts.CartsFragment
import com.bounce.snapstore.presentation.ui.home.HomeFragment
import com.bounce.snapstore.presentation.ui.product.ProductFragment
import com.bounce.snapstore.presentation.ui.search.SearchFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface NetworkComponent {

    fun inject(homeFragment: HomeFragment)
    fun inject(productFragment: ProductFragment)
    fun inject(cartsFragment: CartsFragment)
    fun inject(searchFragment: SearchFragment)

//    @Component.Factory
//    interface Factory {
//        fun create(@BindsInstance application: Application): NetworkComponent
//    }
}