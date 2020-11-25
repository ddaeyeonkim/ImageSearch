package com.improve777.imagesearch.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApiKeyModule::class,
        NetworkModule::class,
        ViewModelFactoryModule::class,
    ]
)
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context,
            @BindsInstance isDebug: Boolean,
            @BindsInstance baseUrl: String,
        ): AppComponent
    }
}