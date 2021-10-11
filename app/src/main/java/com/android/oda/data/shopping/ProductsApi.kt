package com.android.oda.data.shopping

import retrofit2.http.GET

interface ProductsApi {
    @GET(ProductsApiUrls.shoppingInfo)
    suspend fun getShoppingInfo(): ProductsListDto
}