package com.improve777.imagesearch.domain.model

data class Meta(
    val page: Int,
    val isEnd: Boolean,
    val pageableCount: Int?,
    val totalCount: Int?,
) {
    fun getNextPage(): Int? {
        return if (isEnd) {
            null
        } else {
            page + 1
        }
    }
}