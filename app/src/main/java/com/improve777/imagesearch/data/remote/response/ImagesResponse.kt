package com.improve777.imagesearch.data.remote.response

import com.google.gson.annotations.SerializedName

data class ImagesResponse(
    @SerializedName("documents")
    val documents: List<DocumentResponse>?,
    @SerializedName("meta")
    val meta: MetaResponse?,
) : Response

data class DocumentResponse(
    @SerializedName("collection")
    val collection: String?,
    @SerializedName("datetime")
    val datetime: String?,
    @SerializedName("image_url")
    val imageUrl: String?,
    @SerializedName("thumbnail_url")
    val thumbnailUrl: String?,
    @SerializedName("doc_url")
    val docUrl: String?,
    @SerializedName("display_sitename")
    val displaySiteName: String?,
    @SerializedName("width")
    val width: Int?,
    @SerializedName("height")
    val height: Int?,
) : Response

data class MetaResponse(
    @SerializedName("is_end")
    val isEnd: Boolean?,
    @SerializedName("pageable_count")
    val pageableCount: Int?,
    @SerializedName("total_count")
    val totalCount: Int?,
) : Response