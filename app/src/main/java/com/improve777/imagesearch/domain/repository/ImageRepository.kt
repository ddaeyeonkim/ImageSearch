package com.improve777.imagesearch.domain.repository

import androidx.paging.PagingData
import com.improve777.imagesearch.domain.model.Image
import io.reactivex.Flowable

interface ImageRepository {

    fun getImages(
        query: String,
        page: Int,
        size: Int,
    ): Flowable<PagingData<Image>>
}