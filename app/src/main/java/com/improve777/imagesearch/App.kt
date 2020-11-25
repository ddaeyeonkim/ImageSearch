package com.improve777.imagesearch

import android.app.Application
import com.improve777.imagesearch.di.AppComponent
import com.improve777.imagesearch.di.DaggerAppComponent
import com.improve777.imagesearch.di.DaggerComponentProvider
import com.jakewharton.threetenabp.AndroidThreeTen
import timber.log.Timber
import timber.log.Timber.DebugTree

class App : Application(), DaggerComponentProvider {

    override val appComponent: AppComponent by lazy { initAppComponent() }

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
        initTimber()
    }

    private fun initAppComponent(): AppComponent {
        return DaggerAppComponent.factory()
            .create(
                applicationContext,
                BuildConfig.DEBUG,
                BuildConfig.KAKAO_API_URL,
            )
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }
    }
}