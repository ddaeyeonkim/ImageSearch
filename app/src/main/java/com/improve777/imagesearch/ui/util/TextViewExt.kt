package com.improve777.imagesearch.ui.util

import android.widget.TextView
import androidx.databinding.BindingAdapter
import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter
import timber.log.Timber

@BindingAdapter("app:date")
fun TextView.setDate(dataTime: LocalDateTime?) {
    text = try {
        dataTime?.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) ?: ""
    } catch (e: Exception) {
        Timber.e(e)
        dataTime?.toString()
    }
}