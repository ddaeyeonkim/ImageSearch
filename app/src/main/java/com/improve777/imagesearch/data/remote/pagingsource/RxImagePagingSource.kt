package com.improve777.imagesearch.data.remote.pagingsource

import androidx.paging.rxjava2.RxPagingSource
import com.improve777.imagesearch.data.RemoteImageDataSource
import com.improve777.imagesearch.data.remote.exception.EmptyQueryException
import com.improve777.imagesearch.data.remote.exception.NetworkException
import com.improve777.imagesearch.domain.model.Image
import com.improve777.imagesearch.domain.model.ImagePage
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class RxImagePagingSource(
    private val remote: RemoteImageDataSource,
    private val query: String,
    private val page: Int,
    private val size: Int,
) : RxPagingSource<Int, Image>() {

    override fun loadSingle(params: LoadParams<Int>): Single<LoadResult<Int, Image>> {
        val nextPageNumber = params.key ?: page

        return remote.getImages(query, nextPageNumber, size)
            .subscribeOn(Schedulers.io())
            .map(this::toLoadResult)
            .onErrorReturn {
                if (query.isEmpty()) {
                    LoadResult.Error(EmptyQueryException(it))
                } else {
                    LoadResult.Error(NetworkException(it))
                }
            }
    }

    private fun toLoadResult(page: ImagePage): LoadResult<Int, Image> {
        return LoadResult.Page(
            data = page.images,
            prevKey = null,
            nextKey = page.meta.getNextPage(),
        )
    }
}