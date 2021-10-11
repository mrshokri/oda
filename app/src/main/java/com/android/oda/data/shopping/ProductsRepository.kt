package com.android.oda.data.shopping

import com.android.oda.appUtilities.base.BaseRepositoryDelegation
import com.android.oda.appUtilities.network.ApiResponseWrapper
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

interface ProductsRepository {
    suspend fun getProductsList(): ApiResponseWrapper<ProductsListDto>
}

class ProductsRepositoryImpl(
    private val api: ProductsApi,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : BaseRepositoryDelegation(), ProductsRepository {

    override suspend fun getProductsList(): ApiResponseWrapper<ProductsListDto> {
        return call(dispatcher) {
            api.getShoppingInfo()
        }
    }
}