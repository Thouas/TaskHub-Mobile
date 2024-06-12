package com.lon.taskhub.mvvm.view

import android.os.Build
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowInsetsController
import androidx.annotation.RequiresApi
import com.lon.frame.BaseActivity
import com.lon.taskhub.BR
import com.lon.taskhub.R
import com.lon.taskhub.databinding.ActivityMainBinding
import com.lon.taskhub.mvvm.viewmodel.MainViewModel


class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    override fun getLayoutId(): Int = R.layout.activity_main

    override fun getViewModelId(): Int = BR.main

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.insetsController?.hide(WindowInsets.Type.statusBars() or WindowInsets.Type.navigationBars())
        window.insetsController?.systemBarsBehavior =
            WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE

    }
}