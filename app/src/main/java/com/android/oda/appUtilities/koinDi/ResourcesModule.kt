package com.android.oda.appUtilities.koinDi

import android.content.Context
import android.content.res.Resources
import com.android.oda.appUtilities.util.App
import org.koin.core.qualifier.named
import org.koin.dsl.module


val resourcesModule = module {
    single(named(App.RESOURCES)) { provideResources(get()) }
}

fun provideResources(context: Context): Resources? {
    return context.resources
}
