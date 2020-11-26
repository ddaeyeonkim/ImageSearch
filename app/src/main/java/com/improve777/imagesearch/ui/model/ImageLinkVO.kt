package com.improve777.imagesearch.ui.model

import android.os.Parcel
import android.os.Parcelable

data class ImageLinkVO(val url: String) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.readString() ?: "")

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ImageLinkVO> {
        override fun createFromParcel(parcel: Parcel): ImageLinkVO {
            return ImageLinkVO(parcel)
        }

        override fun newArray(size: Int): Array<ImageLinkVO?> {
            return arrayOfNulls(size)
        }
    }
}