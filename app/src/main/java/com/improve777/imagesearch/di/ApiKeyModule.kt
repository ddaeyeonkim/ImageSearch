package com.improve777.imagesearch.di

import com.improve777.imagesearch.data.remote.ApiKeyProvider
import com.improve777.imagesearch.data.remote.KakaoApiKeyProvider
import dagger.Binds
import dagger.Module

@Module
abstract class ApiKeyModule {

    @Binds
    abstract fun bindKakaoApiKeyProvider(kakaoApiKeyProvider: KakaoApiKeyProvider): ApiKeyProvider
}