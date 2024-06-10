package com.lon.taskhub.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter4.BaseQuickAdapter
import com.lon.taskhub.databinding.ItemTaskBinding
import com.lon.taskhub.entity.TaskEntity
import kotlin.math.max

class TaskAdapter(tasks: List<TaskEntity>) :
    BaseQuickAdapter<TaskEntity, TaskAdapter.TaskViewHolder>(tasks) {

    companion object {
        @JvmStatic
        @BindingAdapter("items")
        fun RecyclerView.setValues(items: List<TaskEntity>) {

            if (adapter != null) {
                if (adapter is TaskAdapter) {
                    val taskAdapter = adapter as TaskAdapter
                    val size = taskAdapter.items.size
                    taskAdapter.items = items
                    taskAdapter.notifyItemRangeChanged(0, max(size, items.size))

                }
            } else {
                adapter = TaskAdapter(items)
            }

        }
    }


    override fun onBindViewHolder(holder: TaskViewHolder, position: Int, item: TaskEntity?) {
        holder.binding.task = item
        holder.binding.executePendingBindings()
        val layoutParams = holder.itemView.layoutParams
        layoutParams.height = (holder.binding.root.parent as ViewGroup).height / 3
        holder.itemView.layoutParams = layoutParams
    }

    override fun onCreateViewHolder(
        context: Context,
        parent: ViewGroup,
        viewType: Int
    ): TaskViewHolder {
        return TaskViewHolder(parent)
    }

    class TaskViewHolder(
        parent: ViewGroup,
        val binding: ItemTaskBinding = ItemTaskBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    ) : RecyclerView.ViewHolder(binding.root)
}



