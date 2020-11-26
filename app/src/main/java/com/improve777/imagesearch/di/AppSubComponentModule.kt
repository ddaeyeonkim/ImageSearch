package com.improve777.imagesearch.di

import com.improve777.imagesearch.ui.MainComponent
import com.improve777.imagesearch.ui.viewer.ImageViewerComponent
import dagger.Module

@Module(
    subcomponents = [
        MainComponent::class,
        ImageViewerComponent::class,
    ]
)
class AppSubComponentModule