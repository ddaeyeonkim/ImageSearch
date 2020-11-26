package com.improve777.imagesearch.ui.viewer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.improve777.imagesearch.ui.model.ImageVO
import javax.inject.Inject

class ImageViewerViewModel @Inject constructor() : ViewModel() {

    private val _image = MutableLiveData<ImageVO>()
    val image: LiveData<ImageVO> = _image

    fun fetchImage(imageVO: ImageVO?) {
        _image.value = imageVO
    }
}