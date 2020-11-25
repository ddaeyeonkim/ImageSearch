package com.improve777.imagesearch.data.remote.api

import com.improve777.imagesearch.data.remote.request.SortType
import com.improve777.imagesearch.data.remote.response.ImagesResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ImageApi {

    @GET("v2/search/image")
    fun getImages(
        @Header("Authorization") authorization: String,
        @Query("query") query: String,
        @Query("sort") sort: SortType,
        @Query("page") page: Int,
        @Query("size") size: Int,
    ): Single<ImagesResponse>
}