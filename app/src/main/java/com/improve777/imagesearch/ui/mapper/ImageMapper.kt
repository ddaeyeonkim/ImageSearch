package com.improve777.imagesearch.ui.mapper

import com.improve777.imagesearch.domain.model.Image
import com.improve777.imagesearch.ui.model.ImageLinkVO
import com.improve777.imagesearch.ui.model.ImageVO

fun Image.toVO() = ImageVO(
    id = id,
    thumbnailUrl = ImageLinkVO(url = thumbnailUrl.url),
    imageUrl = ImageLinkVO(url = imageUrl.url),
    displaySiteName = displaySiteName,
    dataTime = dataTime,
)