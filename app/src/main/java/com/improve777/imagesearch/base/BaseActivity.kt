package com.improve777.imagesearch.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

open class BaseActivity<B : ViewDataBinding>(
    private val layoutId: Int,
) : AppCompatActivity() {

    private lateinit var _binding: B
    protected val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, layoutId)
        _binding.lifecycleOwner = this
    }
}