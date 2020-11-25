package com.improve777.imagesearch.di

import com.improve777.imagesearch.ui.MainComponent
import dagger.Module

@Module(
    subcomponents = [
        MainComponent::class,
    ]
)
class AppSubComponentModule