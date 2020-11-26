package com.improve777.imagesearch.data.remote.mapper

import com.improve777.imagesearch.data.remote.response.ImagesResponse
import com.improve777.imagesearch.domain.model.Image
import com.improve777.imagesearch.domain.model.ImageLink
import com.improve777.imagesearch.domain.model.ImagePage
import com.improve777.imagesearch.domain.model.Meta
import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter
import timber.log.Timber

fun ImagesResponse.toDomain(page: Int) = ImagePage(
    meta = Meta(
        page = page,
        isEnd = meta?.isEnd ?: false,
        pageableCount = meta?.pageableCount,
        totalCount = meta?.totalCount,
    ),
    images = documents?.map {
        Image(
            id = it.imageUrl?.substringAfter("/") ?: "",
            thumbnailUrl = ImageLink(url = it.thumbnailUrl ?: ""),
            imageUrl = ImageLink(url = it.imageUrl ?: ""),
            displaySiteName = it.displaySiteName ?: "",
            dataTime = try {
                LocalDateTime.parse(it.datetime, DateTimeFormatter.ISO_ZONED_DATE_TIME)
            } catch (e: Exception) {
                Timber.e(e)
                null
            },
        )
    } ?: emptyList()
)