package com.lon.taskhub.main

import com.lon.frame.BaseModel
import com.lon.net.RequestManger
import com.lon.taskhub.api.Api
import com.lon.taskhub.entity.TaskEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class MainModel : BaseModel() {

    suspend fun getTasksByUserId(id: String) = flow {
        val value = RequestManger
            .create(Api::class.java)
            .getTasksByUserId(id)
            .value
        emit(value.orEmpty())
    }.flowOn(Dispatchers.IO)

}