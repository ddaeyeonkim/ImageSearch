package com.improve777.imagesearch.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.improve777.imagesearch.R
import com.improve777.imagesearch.base.BaseActivity
import com.improve777.imagesearch.databinding.ActivityMainBinding
import com.improve777.imagesearch.di.injector
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding>(
    layoutId = R.layout.activity_main,
) {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: MainViewModel by viewModels { viewModelFactory }

    private val adapter: ImagePagingDataAdapter by lazy { ImagePagingDataAdapter(ImageDiffCallback()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        injector.mainFactory().create().inject(this)
        super.onCreate(savedInstanceState)
        binding.vm = viewModel

        initRecyclerView()
        observeViewModel()
    }

    private fun initRecyclerView() {
        binding.rvImages.adapter = adapter
        adapter.addLoadStateListener {
            viewModel.fetchEmpty(adapter.itemCount < 1)
        }
    }

    private fun observeViewModel() {
        viewModel.images.observe(
            this,
            { adapter.submitData(lifecycle, it) }
        )
    }
}