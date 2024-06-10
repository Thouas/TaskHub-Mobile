package com.lon.bas

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.lon.frame.IViewModel
import com.lon.frame.getViewModelClass

abstract class BaseDialog<V : ViewDataBinding, VM : IViewModel>(context: Context) :
    Dialog(context) {
    private lateinit var binding: V
    private lateinit var mViewModel: VM
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.inflate(layoutInflater, getLayoutId(), null, false)
        binding.lifecycleOwner = context as AppCompatActivity
        mViewModel =
            ViewModelProvider(context as AppCompatActivity)[getViewModelClass(this.javaClass)]
        binding.setVariable(getViewModelId(), mViewModel)
        (context as AppCompatActivity).lifecycle.addObserver(mViewModel)
    }

    abstract fun getLayoutId(): Int
    abstract fun getViewModelId(): Int
}