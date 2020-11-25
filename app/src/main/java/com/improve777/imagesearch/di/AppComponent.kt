package com.improve777.imagesearch.di

import android.content.Context
import com.improve777.imagesearch.ui.MainComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApiKeyModule::class,
        NetworkModule::class,
        AppSubComponentModule::class,
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

    fun mainFactory(): MainComponent.Factory
}