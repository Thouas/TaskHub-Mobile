package com.lon.taskhub.mvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.lon.frame.BaseViewModel
import com.lon.taskhub.entity.TaskEntity
import com.lon.taskhub.mvvm.model.MainModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : BaseViewModel<MainModel>() {
    private var _tasks = MutableLiveData<List<TaskEntity>>(emptyList())
    val tasks get() = _tasks
    override fun initView() {

    }

    override fun initData() {
        viewModelScope.launch(Dispatchers.IO) {
            val list: List<TaskEntity>
            try {
                list = model.getTasksByUserId("1").orEmpty()
                launch(Dispatchers.Main) {
                    _tasks.value = list
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
    }
}