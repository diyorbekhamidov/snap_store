package com.bounce.snapstore.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bounce.snapstore.presentation.ui.ViewModelFactory
import com.bounce.snapstore.presentation.ui.carts.CartsViewModel
import com.bounce.snapstore.presentation.ui.home.HomeViewModel
import com.bounce.snapstore.presentation.ui.product.ProductViewModel
import com.bounce.snapstore.presentation.ui.search.SearchViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindsViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @Singleton
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindsHomeViewModel(homeViewModel: HomeViewModel): ViewModel

    @Binds
    @Singleton
    @IntoMap
    @ViewModelKey(ProductViewModel::class)
    abstract fun bindsProductViewModel(productViewModel: ProductViewModel): ViewModel

    @Binds
    @Singleton
    @IntoMap
    @ViewModelKey(CartsViewModel::class)
    abstract fun bindsCartsViewModel(cartsViewModel: CartsViewModel): ViewModel

    @Binds
    @Singleton
    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    abstract fun bindsSearchViewModel(searchViewModel: SearchViewModel): ViewModel
}
