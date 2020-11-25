package com.improve777.imagesearch.domain.model

data class ImageLink(val url: String) {

    companion object {
        val EMPTY = ImageLink("")
    }
}