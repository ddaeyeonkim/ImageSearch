package com.improve777.imagesearch.ui.util

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("app:visibleIf")
fun View.visibleIf(isVisible: Boolean?) {
    visibility = if (isVisible == true) {
        View.VISIBLE
    } else {
        View.INVISIBLE
    }
}