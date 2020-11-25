package com.improve777.imagesearch.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.rxjava2.flowable
import com.improve777.imagesearch.data.remote.pagingsource.RxImagePagingSource
import com.improve777.imagesearch.domain.model.Image
import com.improve777.imagesearch.domain.repository.ImageRepository
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ImageRepositoryImpl @Inject constructor(
    private val remote: RemoteImageDataSource,
) : ImageRepository {

    override fun getImages(
        query: String,
        page: Int,
        size: Int,
    ): Flowable<PagingData<Image>> {
        return Pager<Int, Image>(
            config = PagingConfig(pageSize = size),
            pagingSourceFactory = { RxImagePagingSource(remote, query, page, size) }
        ).flowable
    }
}