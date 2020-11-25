package com.improve777.imagesearch.di

import android.app.Activity

interface DaggerComponentProvider {

    val appComponent: AppComponent
}

/**
 * 액티비티에서 appComponent 에 접근
 */
val Activity.injector get() = (application as DaggerComponentProvider).appComponent