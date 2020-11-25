package com.improve777.imagesearch.data

import com.improve777.imagesearch.domain.model.ImagePage
import io.reactivex.Single

interface RemoteImageDataSource {

    fun getImages(
        query: String,
        page: Int,
        size: Int,
    ): Single<ImagePage>
}