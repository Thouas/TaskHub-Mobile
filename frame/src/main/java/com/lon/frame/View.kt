package com.lon.frame

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import java.lang.reflect.ParameterizedType

interface IView

abstract class BaseActivity<V : ViewDataBinding, VM : IViewModel> : AppCompatActivity(), IView {
    private lateinit var binding: V
    private lateinit var mViewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, getLayoutId())
        binding.lifecycleOwner = this
        mViewModel = ViewModelProvider(this)[getViewModelClass(this.javaClass)]
        binding.setVariable(getViewModelId(), mViewModel)
        lifecycle.addObserver(mViewModel)
    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycle.removeObserver(mViewModel)
        binding.unbind()
    }

    abstract fun getLayoutId(): Int
    abstract fun getViewModelId(): Int

}

abstract class BaseFragment<V : ViewDataBinding, VM : IViewModel> : Fragment(), IView {
    private lateinit var binding: V
    private lateinit var mViewModel: VM

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        binding.lifecycleOwner = this
        mViewModel = ViewModelProvider(this)[getViewModelClass(this.javaClass)]
        lifecycle.addObserver(mViewModel)
        binding.setVariable(getViewModelId(), mViewModel)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycle.removeObserver(mViewModel)
        binding.unbind()
    }

    abstract fun getLayoutId(): Int

    abstract fun getViewModelId(): Int
}

fun <T> getViewModelClass(clazz: Class<*>): Class<T> =
    ((clazz.genericSuperclass as ParameterizedType).actualTypeArguments[1] as Class<T>)