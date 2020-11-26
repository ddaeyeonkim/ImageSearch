package com.improve777.imagesearch.ui.viewer

import com.improve777.imagesearch.di.scope.ActivityScope
import dagger.Subcomponent

@ActivityScope
@Subcomponent(
    modules = [
        ImageViewerModule::class
    ]
)
interface ImageViewerComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): ImageViewerComponent
    }

    fun inject(activity: ImageViewerActivity)
}