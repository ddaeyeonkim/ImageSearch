package com.improve777.imagesearch.ui.model

import android.os.Parcel
import android.os.Parcelable
import org.threeten.bp.LocalDateTime

data class ImageVO(
    val id: String,
    val thumbnailUrl: ImageLinkVO,
    val imageUrl: ImageLinkVO,
    val displaySiteName: String?,
    val dataTime: LocalDateTime?,
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readParcelable(ImageLinkVO::class.java.classLoader) ?: ImageLinkVO(""),
        parcel.readParcelable(ImageLinkVO::class.java.classLoader) ?: ImageLinkVO(""),
        parcel.readString(),
        (parcel.readSerializable() as? LocalDateTime)
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeParcelable(thumbnailUrl, flags)
        parcel.writeParcelable(imageUrl, flags)
        parcel.writeString(displaySiteName)
        parcel.writeSerializable(dataTime)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ImageVO> {
        override fun createFromParcel(parcel: Parcel): ImageVO {
            return ImageVO(parcel)
        }

        override fun newArray(size: Int): Array<ImageVO?> {
            return arrayOfNulls(size)
        }
    }
}