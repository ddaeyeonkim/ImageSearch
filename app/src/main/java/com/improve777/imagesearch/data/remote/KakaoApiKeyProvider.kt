package com.improve777.imagesearch.data.remote

import com.improve777.imagesearch.BuildConfig
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class KakaoApiKeyProvider @Inject constructor() : ApiKeyProvider {
    override val key: String = BuildConfig.KAKAO_API_KEY
}