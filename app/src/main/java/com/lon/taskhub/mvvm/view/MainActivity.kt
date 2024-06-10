package com.lon.taskhub.mvvm.view

import com.lon.frame.BaseActivity
import com.lon.taskhub.BR
import com.lon.taskhub.R
import com.lon.taskhub.databinding.ActivityMainBinding
import com.lon.taskhub.mvvm.viewmodel.MainViewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    override fun getLayoutId(): Int = R.layout.activity_main

    override fun getViewModelId(): Int = BR.main
}