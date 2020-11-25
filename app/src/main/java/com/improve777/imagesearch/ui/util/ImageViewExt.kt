package com.improve777.imagesearch.ui.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.improve777.imagesearch.R
import com.improve777.imagesearch.domain.model.ImageLink

@BindingAdapter("app:loadUrl")
fun ImageView.loadUrl(link: ImageLink?) {
    Glide.with(this)
        .load(link?.url)
        .override(this.width, this.height)
        .error(R.drawable.ic_launcher_background)
        .centerCrop()
        .transform(RoundedCorners(20))
        .transition(DrawableTransitionOptions.withCrossFade(150))
        .into(this)
}