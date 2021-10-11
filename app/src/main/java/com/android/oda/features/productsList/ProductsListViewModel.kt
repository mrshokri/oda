package com.android.oda.features.productsList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.android.oda.appUtilities.base.BaseViewModel
import com.android.oda.appUtilities.network.ApiResponseWrapper
import com.android.oda.data.shopping.ProductsListDto
import com.android.oda.data.shopping.ProductsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ProductsListViewModel(
    private val productsRepository: ProductsRepository
) : BaseViewModel() {

    init {
        showProgress(true)
        getProductsList()
    }

    private var totalNumber = 0
    private var currentShoppingValue = 0.0

    private var _shoppingInfo: MutableLiveData<Pair<Int, Double>> = MutableLiveData()
    val shoppingInfo: LiveData<Pair<Int, Double>>
        get() = _shoppingInfo

    private var _productsListResult: MutableLiveData<ProductsListDto> = MutableLiveData()
    val productsListResult: LiveData<ProductsListDto>
        get() = _productsListResult

    private fun getProductsList() = viewModelScope.launch(Dispatchers.IO) {
        when (val response = productsRepository.getProductsList()) {
            is ApiResponseWrapper.Success -> {
                showProgress(false)
                _productsListResult.postValue(response.value)
            }
        }
    }

    fun quantityChanged(newQuality: Int, totalPrice: Float) {
        totalNumber += newQuality
        currentShoppingValue += totalPrice
        _shoppingInfo.postValue(Pair(totalNumber, currentShoppingValue))
    }
}