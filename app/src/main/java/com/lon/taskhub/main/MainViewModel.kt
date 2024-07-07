package com.lon.taskhub.main

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.lon.frame.BaseViewModel
import com.lon.taskhub.entity.TaskEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : BaseViewModel<MainModel>() {
    private var _tasks = MutableLiveData<List<TaskEntity>>(emptyList())
    val tasks get() = _tasks

    val refreshLoadMoreState = MutableLiveData(0)

    override fun initData(owner: LifecycleOwner) {

        getTasks("1")
        refreshLoadMoreState.observe(owner) {
            when (it) {
                1 -> getTasks("1")
                else -> {}
            }
        }
    }

    private fun getTasks(id: String) {
        viewModelScope.launch {
            model.getTasksByUserId(id)
                .catch { it.printStackTrace() }
                .collect { _tasks.value = it }
        }
    }

}