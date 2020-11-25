package com.improve777.imagesearch.ui

import com.improve777.imagesearch.di.scope.ActivityScope
import dagger.Subcomponent

@ActivityScope
@Subcomponent(
    modules = [
        MainModule::class
    ]
)
interface MainComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): MainComponent
    }

    fun inject(activity: MainActivity)
}