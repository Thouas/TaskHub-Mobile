package com.lon.frame

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import java.lang.reflect.ParameterizedType

interface IViewModel : DefaultLifecycleObserver {
    fun initData(owner: LifecycleOwner)
}

abstract class BaseViewModel<M : IModel> : ViewModel(), IViewModel {

    protected lateinit var model: M

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        model = (javaClass.genericSuperclass as ParameterizedType)
            .actualTypeArguments[0]
            .let { it as Class<M> }
            .getDeclaredConstructor()
            .newInstance()
        initData(owner)
    }
}