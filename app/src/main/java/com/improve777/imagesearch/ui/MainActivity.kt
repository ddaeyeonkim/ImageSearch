package com.improve777.imagesearch.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.paging.LoadState
import com.improve777.imagesearch.R
import com.improve777.imagesearch.base.BaseActivity
import com.improve777.imagesearch.databinding.ActivityMainBinding
import com.improve777.imagesearch.di.injector
import com.improve777.imagesearch.ui.util.EventObserver
import com.improve777.imagesearch.ui.util.dp2px
import com.improve777.imagesearch.ui.viewer.ImageViewerActivity
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding>(
    layoutId = R.layout.activity_main,
) {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: MainViewModel by viewModels { viewModelFactory }

    private val adapter: ImagePagingDataAdapter by lazy { ImagePagingDataAdapter(viewModel, ImageDiffCallback()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        injector.mainFactory().create().inject(this)
        super.onCreate(savedInstanceState)
        binding.vm = viewModel

        initRecyclerView()
        observeViewModel()
    }

    private fun initRecyclerView() {
        binding.rvImages.apply {
            adapter = this@MainActivity.adapter
            addItemDecoration(ImageItemDecoration(dp2px(2)))
        }
        adapter.addLoadStateListener {
            submitLoadStateError(it.refresh)
            submitLoadStateError(it.append)
            viewModel.fetchEmpty(adapter.itemCount < 1)
        }
    }

    private fun submitLoadStateError(loadState: LoadState) {
        if (loadState is LoadState.Error) {
            viewModel.onErrorHandle(loadState.error)
        }
    }

    private fun observeViewModel() {
        viewModel.images.observe(
            this,
            { adapter.submitData(lifecycle, it) }
        )

        viewModel.actionImageViewer.observe(
            this,
            EventObserver {
                startActivity(
                    ImageViewerActivity.getIntent(this, it)
                )
            }
        )

        viewModel.toastEvent.observe(
            this,
            EventObserver {
                Toast.makeText(this, getString(it), Toast.LENGTH_SHORT).show()
            }
        )
    }
}