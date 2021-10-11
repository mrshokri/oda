package com.android.oda

import androidx.multidex.MultiDexApplication
import com.android.oda.appUtilities.koinDi.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class OdaApplication : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        configureKoin()
    }

    private fun configureKoin() {
        startKoin {
            androidLogger(Level.ERROR)
            modules(
                listOf(
                    appModule,
                    viewModelModule,
                    repositoryModule,
                    assetModule,
                    networkModule,
                    preferenceModule,
                    resourcesModule
                )
            )
            androidContext(this@OdaApplication)
        }
    }
}