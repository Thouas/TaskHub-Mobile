package com.lon.taskhub.mvvm.model

import com.lon.frame.BaseModel
import com.lon.net.RequestManger
import com.lon.taskhub.api.Api

class MainModel : BaseModel() {

    suspend fun getTasksByUserId(id: String) = RequestManger
        .create(Api::class.java)
        .getTasksByUserId(id)
        .value

}