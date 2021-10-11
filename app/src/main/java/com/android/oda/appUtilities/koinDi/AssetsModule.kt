package com.android.oda.appUtilities.koinDi

import android.content.Context
import android.content.res.AssetManager
import org.koin.core.qualifier.named
import org.koin.dsl.module

const val APP_ASSET_MANAGER ="APP_ASSET_MANAGER"


val assetModule = module {
    single (named(APP_ASSET_MANAGER)){ provideAssets(get()) }
}

fun provideAssets(context: Context) : AssetManager? {
    return context.assets
}
