package com.lon.taskhub.main

import android.os.Bundle
import com.lon.frame.BaseActivity
import com.lon.taskhub.BR
import com.lon.taskhub.R
import com.lon.taskhub.databinding.ActivityMainBinding


class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    override fun getLayoutId(): Int = R.layout.activity_main

    override fun getViewModelId(): Int = BR.main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(binding.toolbar)
    }
}