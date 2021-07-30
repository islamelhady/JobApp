package com.elhady.ijobs.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.elhady.ijobs.data.model.Job
import com.elhady.ijobs.databinding.ItemJobBinding

/**
 * Created by islam elhady on 22-Mar-21.
 */
class IjobAdapter(val callback: JobClick) :
    ListAdapter<Job, IjobAdapter.JobViewHolder>(DiffCallback) {


    companion object DiffCallback : DiffUtil.ItemCallback<Job>() {
        override fun areItemsTheSame(oldItem: Job, newItem: Job): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Job, newItem: Job): Boolean {
            return newItem.id == oldItem.id
        }
    }


    class JobViewHolder(val viewDataBinding: ItemJobBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root) {

        fun bind(listener: JobClick, job: Job) {
            viewDataBinding.job = job
            viewDataBinding.jobclick = listener
            viewDataBinding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): JobViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemJobBinding.inflate(layoutInflater, parent, false)
                return JobViewHolder(binding)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobViewHolder {
        return JobViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: JobViewHolder, position: Int) {
        holder.viewDataBinding.also {
            holder.bind(callback, getItem(position))
        }
    }
}

class JobClick(val block: (Job, Int) -> Unit) {
    /**
     * Called when a item is clicked
     * @param job the job that was clicked
     */
    fun onClick(item: Job, version: Int) = block(item, version)
    fun onFavoriteClick(item: Job, version: Int) = block(item, version)
}