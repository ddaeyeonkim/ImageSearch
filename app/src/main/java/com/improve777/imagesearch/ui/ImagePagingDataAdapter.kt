package com.improve777.imagesearch.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.improve777.imagesearch.R
import com.improve777.imagesearch.databinding.ItemImageBinding
import com.improve777.imagesearch.ui.model.ImageVO

class ImagePagingDataAdapter(
    private val onClickImageListener: OnClickImageListener,
    diffCallback: DiffUtil.ItemCallback<ImageVO>
) : PagingDataAdapter<ImageVO, ImageViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_image,
                parent,
                false
            ),
            onClickImageListener
        )
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}

interface OnClickImageListener {
    fun onClickImage(image: ImageVO)
}

class ImageViewHolder(
    private val binding: ItemImageBinding,
    onClickImageListener: OnClickImageListener,
) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.action = onClickImageListener
    }

    fun bind(item: ImageVO?) {
        binding.item = item
    }
}

class ImageDiffCallback : DiffUtil.ItemCallback<ImageVO>() {

    override fun areItemsTheSame(oldItem: ImageVO, newItem: ImageVO): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ImageVO, newItem: ImageVO): Boolean {
        return oldItem == newItem
    }
}