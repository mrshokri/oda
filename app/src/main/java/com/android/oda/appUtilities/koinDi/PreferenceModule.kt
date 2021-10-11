package com.android.oda.appUtilities.koinDi

import android.content.Context
import android.content.SharedPreferences
import com.android.oda.appUtilities.util.App
import org.koin.core.qualifier.named
import org.koin.dsl.module


val preferenceModule = module {
    single(named(App.PREFERENCES)) {
        providePreferences(
                get(),
                get(named(App.PREFERENCES_NAME))
        )
    }
}

fun providePreferences(context: Context, preferenceName: String): SharedPreferences? {
    return context.getSharedPreferences(preferenceName, Context.MODE_PRIVATE)
}
