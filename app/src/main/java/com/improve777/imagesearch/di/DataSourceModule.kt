package com.improve777.imagesearch.di

import com.improve777.imagesearch.data.RemoteImageDataSource
import com.improve777.imagesearch.data.remote.RemoteImageDataSourceImpl
import dagger.Binds
import dagger.Module

@Module
abstract class DataSourceModule {

    @Binds
    abstract fun bindDataSource(imageDataSource: RemoteImageDataSourceImpl): RemoteImageDataSource
}