package com.elhady.ijobs.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.elhady.ijobs.data.model.Ijob
import com.elhady.ijobs.databinding.ItemJobBinding

/**
 * Created by islam elhady on 22-Mar-21.
 */
class IjobAdapter() : ListAdapter<Ijob, IjobAdapter.JobViewHolder>(DiffCallback) {


    companion object DiffCallback : DiffUtil.ItemCallback<Ijob>() {
        override fun areItemsTheSame(oldItem: Ijob, newItem: Ijob): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Ijob, newItem: Ijob): Boolean {
            return newItem.id == oldItem.id
        }
    }


    class JobViewHolder(val viewDataBinding: ItemJobBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root) {

        fun bind(ijob: Ijob){
            viewDataBinding.job = ijob
//            viewDataBinding.cardview = viewDataBinding.itemContainer
//            viewDataBinding.cardview?.transitionName = job.company
//            viewDataBinding.jobclick = listener
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
            holder.bind( getItem(position))
        }
    }
}

class JobClick(val block: (Ijob, View) -> Unit) {
    fun onClick(ijob: Ijob, view: View) = block(ijob, view)
}