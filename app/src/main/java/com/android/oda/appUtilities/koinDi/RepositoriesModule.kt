package com.android.oda.appUtilities.koinDi

import com.android.oda.appUtilities.util.RetrofitType
import com.android.oda.data.shopping.ProductsRepository
import com.android.oda.data.shopping.ProductsRepositoryImpl
import org.koin.core.qualifier.named
import org.koin.dsl.module

/*
* This class is based on server repository directories
*
* */
val repositoryModule = module {

    single<ProductsRepository> {
        ProductsRepositoryImpl(
            createApi(get(named(RetrofitType.MOCK)))
        )
    }

}
