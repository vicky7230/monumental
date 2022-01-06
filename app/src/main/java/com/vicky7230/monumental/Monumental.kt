package com.vicky7230.monumental

import android.app.Application
import com.vicky7230.monumental.di.appModule
import com.vicky7230.monumental.di.networkModule
import com.vicky7230.monumental.ui._1splash.splashActivityModule
import com.vicky7230.monumental.ui._2onboarding.onboardActivityModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

class Monumental : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@Monumental)
            modules(
                listOf(
                    appModule,
                    networkModule,
                    splashActivityModule,
                    onboardActivityModule
                )
            )
        }
    }

}