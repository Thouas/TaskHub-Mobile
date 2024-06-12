package com.lon.taskhub.api

import com.lon.taskhub.entity.TaskEntity
import com.lon.net.respuest.BaseRespuest
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("tasks/getTasksByUserId")
    suspend fun getTasksByUserId(@Query("userId") userId: String): BaseRespuest<List<TaskEntity>>
}