package com.improve777.imagesearch.ui.util

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.facebook.shimmer.Shimmer
import com.facebook.shimmer.ShimmerDrawable
import com.improve777.imagesearch.R
import com.improve777.imagesearch.ui.model.ImageLinkVO

@BindingAdapter("app:loadUrl")
fun ImageView.loadUrl(link: ImageLinkVO?) {
    Glide.with(this)
        .load(link?.url)
        .override(this.width, this.height)
        .placeholder(context.getShimmerDrawable())
        .error(R.drawable.ic_error_image_bg)
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
        .error(R.drawable.ic_not_found)
        .transition(DrawableTransitionOptions.withCrossFade(150))
        .into(this)
}

fun Context.getShimmerDrawable(): Drawable {
    val shimmer = Shimmer.ColorHighlightBuilder()
        .setDuration(1000)
        .setBaseColor(ContextCompat.getColor(this, R.color.shimmer_color))
        .setBaseAlpha(0.7f)
        .setHighlightAlpha(0.6f)
        .setDirection(Shimmer.Direction.LEFT_TO_RIGHT)
        .setAutoStart(true)
        .build()

    return ShimmerDrawable().apply {
        setShimmer(shimmer)
    }
}

fun Context.getCircularProgressDrawable() =
    CircularProgressDrawable(this).apply {
        setStyle(CircularProgressDrawable.LARGE)
        setColorSchemeColors(ContextCompat.getColor(this@getCircularProgressDrawable, R.color.color_accent))
        start()
    }