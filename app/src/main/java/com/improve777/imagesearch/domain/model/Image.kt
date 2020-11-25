package com.improve777.imagesearch.domain.model

import org.threeten.bp.LocalDateTime

data class Image(
    val id: String,
    val thumbnailUrl: ImageLink,
    val imageUrl: ImageLink,
    val displaySiteName: String?,
    val dataTime: LocalDateTime?,
)