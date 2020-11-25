package com.improve777.imagesearch.data.remote

import com.improve777.imagesearch.data.RemoteImageDataSource
import com.improve777.imagesearch.data.remote.api.ImageApi
import com.improve777.imagesearch.data.remote.mapper.toDomain
import com.improve777.imagesearch.data.remote.request.SortType
import com.improve777.imagesearch.domain.model.ImagePage
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteImageDataSourceImpl @Inject constructor(
    private val kakaoApiKeyProvider: ApiKeyProvider,
    private val imageApi: ImageApi,
) : RemoteImageDataSource {

    override fun getImages(
        query: String,
        page: Int,
        size: Int,
    ): Single<ImagePage> {
        return imageApi.getImages(
            authorization = kakaoApiKeyProvider.key,
            query = query,
            sort = SortType.ACCURACY,
            page = page,
            size = size,
        ).map {
            it.toDomain(page)
        }
    }
}