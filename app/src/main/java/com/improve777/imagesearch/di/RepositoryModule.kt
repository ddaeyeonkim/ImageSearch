package com.improve777.imagesearch.di

import com.improve777.imagesearch.data.ImageRepositoryImpl
import com.improve777.imagesearch.domain.repository.ImageRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {
    @Binds
    abstract fun bindImageRepository(imageRepository: ImageRepositoryImpl): ImageRepository
}