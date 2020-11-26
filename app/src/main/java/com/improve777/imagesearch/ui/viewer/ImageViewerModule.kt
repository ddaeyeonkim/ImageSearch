package com.improve777.imagesearch.ui.viewer

import androidx.lifecycle.ViewModel
import com.improve777.imagesearch.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ImageViewerModule {

    @Binds
    @IntoMap
    @ViewModelKey(ImageViewerViewModel::class)
    abstract fun bindImageViewerViewModel(imageViewerViewModel: ImageViewerViewModel): ViewModel
}