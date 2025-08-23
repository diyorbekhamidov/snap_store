package com.bounce.snapstore.di.component;

import androidx.lifecycle.ViewModel;
import com.bounce.snapstore.data.network.ProductApiService;
import com.bounce.snapstore.di.module.NetworkModule;
import com.bounce.snapstore.di.module.NetworkModule_ProvideApiServiceFactory;
import com.bounce.snapstore.di.module.NetworkModule_ProvideBaseUrlFactory;
import com.bounce.snapstore.di.module.NetworkModule_ProvideCartsRepositoryFactory;
import com.bounce.snapstore.di.module.NetworkModule_ProvideCartsUseCaseFactory;
import com.bounce.snapstore.di.module.NetworkModule_ProvideGsonConvertorFactoryFactory;
import com.bounce.snapstore.di.module.NetworkModule_ProvideProductRepositoryFactory;
import com.bounce.snapstore.di.module.NetworkModule_ProvideProductUseCaseFactory;
import com.bounce.snapstore.di.module.NetworkModule_ProvideRetrofitFactory;
import com.bounce.snapstore.di.module.NetworkModule_ProvideRxJavaCallAdapterFactoryFactory;
import com.bounce.snapstore.domain.repository.CartsRepository;
import com.bounce.snapstore.domain.repository.ProductRepository;
import com.bounce.snapstore.domain.usecase.CartsUseCase;
import com.bounce.snapstore.domain.usecase.ProductUseCase;
import com.bounce.snapstore.presentation.ui.ViewModelFactory;
import com.bounce.snapstore.presentation.ui.carts.CartsFragment;
import com.bounce.snapstore.presentation.ui.carts.CartsFragment_MembersInjector;
import com.bounce.snapstore.presentation.ui.carts.CartsViewModel;
import com.bounce.snapstore.presentation.ui.carts.CartsViewModel_Factory;
import com.bounce.snapstore.presentation.ui.home.HomeFragment;
import com.bounce.snapstore.presentation.ui.home.HomeFragment_MembersInjector;
import com.bounce.snapstore.presentation.ui.home.HomeViewModel;
import com.bounce.snapstore.presentation.ui.home.HomeViewModel_Factory;
import com.bounce.snapstore.presentation.ui.product.ProductFragment;
import com.bounce.snapstore.presentation.ui.product.ProductFragment_MembersInjector;
import com.bounce.snapstore.presentation.ui.product.ProductViewModel;
import com.bounce.snapstore.presentation.ui.product.ProductViewModel_Factory;
import com.bounce.snapstore.presentation.ui.search.SearchFragment;
import com.bounce.snapstore.presentation.ui.search.SearchFragment_MembersInjector;
import com.bounce.snapstore.presentation.ui.search.SearchViewModel;
import com.bounce.snapstore.presentation.ui.search.SearchViewModel_Factory;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.MapBuilder;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import java.util.Map;
import javax.annotation.processing.Generated;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class DaggerNetworkComponent {
  private DaggerNetworkComponent() {
  }

  public static Builder builder() {
    return new Builder();
  }

  public static NetworkComponent create() {
    return new Builder().build();
  }

  public static final class Builder {
    private NetworkModule networkModule;

    private Builder() {
    }

    public Builder networkModule(NetworkModule networkModule) {
      this.networkModule = Preconditions.checkNotNull(networkModule);
      return this;
    }

    public NetworkComponent build() {
      if (networkModule == null) {
        this.networkModule = new NetworkModule();
      }
      return new NetworkComponentImpl(networkModule);
    }
  }

  private static final class NetworkComponentImpl implements NetworkComponent {
    private final NetworkComponentImpl networkComponentImpl = this;

    private Provider<String> provideBaseUrlProvider;

    private Provider<GsonConverterFactory> provideGsonConvertorFactoryProvider;

    private Provider<RxJava3CallAdapterFactory> provideRxJavaCallAdapterFactoryProvider;

    private Provider<Retrofit> provideRetrofitProvider;

    private Provider<ProductApiService> provideApiServiceProvider;

    private Provider<ProductRepository> provideProductRepositoryProvider;

    private Provider<ProductUseCase> provideProductUseCaseProvider;

    private Provider<HomeViewModel> homeViewModelProvider;

    private Provider<ViewModel> bindsHomeViewModelProvider;

    private Provider<ProductViewModel> productViewModelProvider;

    private Provider<ViewModel> bindsProductViewModelProvider;

    private Provider<CartsRepository> provideCartsRepositoryProvider;

    private Provider<CartsUseCase> provideCartsUseCaseProvider;

    private Provider<CartsViewModel> cartsViewModelProvider;

    private Provider<ViewModel> bindsCartsViewModelProvider;

    private Provider<SearchViewModel> searchViewModelProvider;

    private Provider<ViewModel> bindsSearchViewModelProvider;

    private NetworkComponentImpl(NetworkModule networkModuleParam) {

      initialize(networkModuleParam);

    }

    private Map<Class<? extends ViewModel>, javax.inject.Provider<ViewModel>> mapOfClassOfAndProviderOfViewModel(
        ) {
      return MapBuilder.<Class<? extends ViewModel>, javax.inject.Provider<ViewModel>>newMapBuilder(4).put(HomeViewModel.class, bindsHomeViewModelProvider).put(ProductViewModel.class, bindsProductViewModelProvider).put(CartsViewModel.class, bindsCartsViewModelProvider).put(SearchViewModel.class, bindsSearchViewModelProvider).build();
    }

    private ViewModelFactory viewModelFactory() {
      return new ViewModelFactory(mapOfClassOfAndProviderOfViewModel());
    }

    @SuppressWarnings("unchecked")
    private void initialize(final NetworkModule networkModuleParam) {
      this.provideBaseUrlProvider = DoubleCheck.provider(NetworkModule_ProvideBaseUrlFactory.create(networkModuleParam));
      this.provideGsonConvertorFactoryProvider = DoubleCheck.provider(NetworkModule_ProvideGsonConvertorFactoryFactory.create(networkModuleParam));
      this.provideRxJavaCallAdapterFactoryProvider = DoubleCheck.provider(NetworkModule_ProvideRxJavaCallAdapterFactoryFactory.create(networkModuleParam));
      this.provideRetrofitProvider = DoubleCheck.provider(NetworkModule_ProvideRetrofitFactory.create(networkModuleParam, provideBaseUrlProvider, provideGsonConvertorFactoryProvider, provideRxJavaCallAdapterFactoryProvider));
      this.provideApiServiceProvider = DoubleCheck.provider(NetworkModule_ProvideApiServiceFactory.create(networkModuleParam, provideRetrofitProvider));
      this.provideProductRepositoryProvider = DoubleCheck.provider(NetworkModule_ProvideProductRepositoryFactory.create(networkModuleParam, provideApiServiceProvider));
      this.provideProductUseCaseProvider = DoubleCheck.provider(NetworkModule_ProvideProductUseCaseFactory.create(networkModuleParam, provideProductRepositoryProvider));
      this.homeViewModelProvider = HomeViewModel_Factory.create(provideProductUseCaseProvider);
      this.bindsHomeViewModelProvider = DoubleCheck.provider((Provider) homeViewModelProvider);
      this.productViewModelProvider = ProductViewModel_Factory.create(provideProductUseCaseProvider);
      this.bindsProductViewModelProvider = DoubleCheck.provider((Provider) productViewModelProvider);
      this.provideCartsRepositoryProvider = DoubleCheck.provider(NetworkModule_ProvideCartsRepositoryFactory.create(networkModuleParam, provideApiServiceProvider));
      this.provideCartsUseCaseProvider = DoubleCheck.provider(NetworkModule_ProvideCartsUseCaseFactory.create(networkModuleParam, provideCartsRepositoryProvider, provideProductUseCaseProvider));
      this.cartsViewModelProvider = CartsViewModel_Factory.create(provideCartsUseCaseProvider);
      this.bindsCartsViewModelProvider = DoubleCheck.provider((Provider) cartsViewModelProvider);
      this.searchViewModelProvider = SearchViewModel_Factory.create(provideProductUseCaseProvider);
      this.bindsSearchViewModelProvider = DoubleCheck.provider((Provider) searchViewModelProvider);
    }

    @Override
    public void inject(HomeFragment homeFragment) {
      injectHomeFragment(homeFragment);
    }

    @Override
    public void inject(ProductFragment productFragment) {
      injectProductFragment(productFragment);
    }

    @Override
    public void inject(CartsFragment cartsFragment) {
      injectCartsFragment(cartsFragment);
    }

    @Override
    public void inject(SearchFragment searchFragment) {
      injectSearchFragment(searchFragment);
    }

    private HomeFragment injectHomeFragment(HomeFragment instance) {
      HomeFragment_MembersInjector.injectViewModelFactory(instance, viewModelFactory());
      return instance;
    }

    private ProductFragment injectProductFragment(ProductFragment instance) {
      ProductFragment_MembersInjector.injectViewModelFactory(instance, viewModelFactory());
      return instance;
    }

    private CartsFragment injectCartsFragment(CartsFragment instance) {
      CartsFragment_MembersInjector.injectViewModelFactory(instance, viewModelFactory());
      return instance;
    }

    private SearchFragment injectSearchFragment(SearchFragment instance) {
      SearchFragment_MembersInjector.injectViewModelFactory(instance, viewModelFactory());
      return instance;
    }
  }
}
