package com.lon.taskhub.main

import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.lon.taskhub.adapter.TaskAdapter
import com.lon.taskhub.entity.TaskEntity
import com.scwang.smart.refresh.footer.ClassicsFooter
import com.scwang.smart.refresh.header.ClassicsHeader
import com.scwang.smart.refresh.layout.SmartRefreshLayout
import com.scwang.smart.refresh.layout.api.RefreshLayout
import com.scwang.smart.refresh.layout.constant.RefreshState
import com.scwang.smart.refresh.layout.listener.OnRefreshLoadMoreListener
import kotlin.math.max

object Utils {
//    @JvmStatic
//    @BindingAdapter("refreshing")
//    fun setRefreshing(refreshLayout: RefreshLayout, state: Int) {
//        when (state) {
//            0 -> {
//                refreshLayout.finishRefresh()
//                refreshLayout.finishLoadMore()
//            }
//
//            1 -> refreshLayout.autoRefresh()
//            2 -> refreshLayout.autoLoadMore()
//            -1 -> refreshLayout.finishRefresh(500)
//            -2 -> refreshLayout.finishLoadMore(500)
//        }
//
//    }
//
//    @JvmStatic
//    @InverseBindingAdapter(attribute = "refreshing", event = "refreshingAttrChanged")
//    fun RefreshLayout.refreshing(): Int = when (state) {
//        RefreshState.None -> 0
//        RefreshState.Refreshing -> 1
//        RefreshState.Loading -> 2
//        RefreshState.RefreshFinish -> -1
//        RefreshState.LoadFinish -> -2
//        else -> 0
//    }
}