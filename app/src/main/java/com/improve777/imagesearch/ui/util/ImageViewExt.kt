package com.improve777.imagesearch.ui.util

import android.content.Context
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.improve777.imagesearch.R
import com.improve777.imagesearch.domain.model.ImageLink
import com.improve777.imagesearch.ui.model.ImageLinkVO

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

@BindingAdapter("app:loadFullUrl")
fun ImageView.loadFullUrl(link: ImageLinkVO?) {
    val circularProgressDrawable = context.getCircularProgressDrawable()

    Glide.with(this)
        .load(link?.url)
        .placeholder(circularProgressDrawable)
        .error(R.drawable.ic_launcher_background)
        .transition(DrawableTransitionOptions.withCrossFade(150))
        .into(this)
}

fun Context.getCircularProgressDrawable() =
    CircularProgressDrawable(this).apply {
        setStyle(CircularProgressDrawable.LARGE)
        setColorSchemeColors(ContextCompat.getColor(this@getCircularProgressDrawable, R.color.color_accent))
        start()
    }