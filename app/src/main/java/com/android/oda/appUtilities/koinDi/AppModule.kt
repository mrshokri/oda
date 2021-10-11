package com.android.oda.appUtilities.koinDi

import com.android.oda.BuildConfig
import com.android.oda.appUtilities.util.App
import org.koin.core.qualifier.named
import org.koin.dsl.module

val appModule = module {
    single(named(App.BASE_URL)) { BuildConfig.API_BASE_URL }
    single(named(App.NETWORK_TIMEOUT)) { BuildConfig.SERVICE_TIME_OUT_MILLI_SEC }
    single(named(App.PREFERENCES_NAME)) { BuildConfig.PREFERENCES }
}
