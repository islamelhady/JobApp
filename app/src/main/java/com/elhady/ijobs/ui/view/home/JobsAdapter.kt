package com.elhady.ijobs.ui.view.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.elhady.ijobs.data.model.Job
import com.elhady.ijobs.databinding.ItemJobBinding

class JobsAdapter(private val callBack: JobItemClick) :
    ListAdapter<Job, JobsAdapter.JobsViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<Job>() {
        override fun areItemsTheSame(oldItem: Job, newItem: Job): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Job, newItem: Job): Boolean {
            return newItem.id == oldItem.id
        }
    }

    class JobsViewHolder(val viewDataBinding: ItemJobBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root) {
        fun bind(listener: JobItemClick, job: Job) {
            viewDataBinding.job = job
            viewDataBinding.cardview = viewDataBinding.itemContainer
            viewDataBinding.jobclick = listener
            viewDataBinding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): JobsViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemJobBinding.inflate(layoutInflater, parent, false)
                return JobsViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobsViewHolder {
        return JobsViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: JobsViewHolder, position: Int) {
        holder.viewDataBinding.also {
            holder.bind(callBack, getItem(position))
        }
    }
}

class JobItemClick(val block: (Job) -> Unit) {
    fun onClick(job: Job) = block(job)
}