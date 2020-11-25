package com.improve777.imagesearch.data.remote.request

import com.google.gson.annotations.SerializedName

enum class SortType {
    @SerializedName("accuracy")
    ACCURACY,
    @SerializedName("latest")
    LATEST,
}