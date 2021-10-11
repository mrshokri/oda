package com.android.oda.appUtilities.koinDi

import com.android.oda.features.productsList.ProductsListViewModel
import com.android.oda.features.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SplashViewModel() }
    viewModel { ProductsListViewModel(get()) }
}


