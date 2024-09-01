package com.bounce.snapstore.presentation.di.component

import android.app.Application
import androidx.fragment.app.Fragment
import com.bounce.snapstore.MyApplication
import com.bounce.snapstore.presentation.MainActivity
import com.bounce.snapstore.presentation.di.module.NetworkModule
import com.bounce.snapstore.presentation.di.module.ViewModelModule
import com.bounce.snapstore.presentation.ui.carts.CartsFragment
import com.bounce.snapstore.presentation.ui.home.HomeFragment
import com.bounce.snapstore.presentation.ui.product.ProductFragment
import com.bounce.snapstore.presentation.ui.search.SearchFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, ViewModelModule::class])
interface NetworkComponent {
    fun inject(homeFragment: HomeFragment)
    fun inject(productFragment: ProductFragment)
    fun inject(cartsFragment: CartsFragment)
    fun inject(searchFragment: SearchFragment)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): NetworkComponent
    }
}