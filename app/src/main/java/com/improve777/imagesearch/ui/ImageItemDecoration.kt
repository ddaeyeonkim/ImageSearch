package com.improve777.imagesearch.ui

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ImageItemDecoration(private val margin: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view)

        if (position % 3 == 0) {
            outRect.left = margin
        }

        if (position < 3) {
            outRect.top = margin
        }

        outRect.bottom = margin
        outRect.right = margin
    }
}