package com.lon.taskhub.entity

data class TaskEntity(
    var id: Int = 0,
    val title: String,
    var description: String,
    var status: String,
    var priority: String,
    var dueDate: String,
)