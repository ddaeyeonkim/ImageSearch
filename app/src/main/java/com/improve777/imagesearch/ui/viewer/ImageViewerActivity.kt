package com.improve777.imagesearch.ui.viewer

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import com.improve777.imagesearch.R
import com.improve777.imagesearch.base.BaseActivity
import com.improve777.imagesearch.databinding.ActivityImageViewerBinding
import com.improve777.imagesearch.di.injector
import com.improve777.imagesearch.ui.model.ImageVO
import javax.inject.Inject

class ImageViewerActivity : BaseActivity<ActivityImageViewerBinding>(
    layoutId = R.layout.activity_image_viewer,
) {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: ImageViewerViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        injector.imageViewerFactory().create().inject(this)
        super.onCreate(savedInstanceState)

        binding.vm = viewModel
        viewModel.fetchImage(intent.getParcelableExtra(EXTRA_IMAGE))
    }

    companion object {
        private const val EXTRA_IMAGE = "EXTRA_IMAGE"

        fun getIntent(
            context: Context,
            imageVO: ImageVO,
        ): Intent {
            return Intent(context, ImageViewerActivity::class.java).apply {
                putExtras(
                    bundleOf(
                        EXTRA_IMAGE to imageVO,
                    )
                )
            }
        }
    }
}