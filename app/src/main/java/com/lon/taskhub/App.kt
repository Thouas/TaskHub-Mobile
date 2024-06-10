package com.lon.taskhub

import android.app.Application
import com.lon.net.RequestManger

class App:Application() {
    override fun onCreate() {
        super.onCreate()
        RequestManger.init("http://192.168.31.104:8080/task_hub/")
    }
}