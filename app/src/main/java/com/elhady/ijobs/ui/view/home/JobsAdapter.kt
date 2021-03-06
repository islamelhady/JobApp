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

    /**
     * Callback for calculating the diff between two non-null items in a list.
     *
     * Used by ListAdapter to calculate the minimum number of changes between and old list and a new
     * list that's been passed to `submitList`.
     */
    companion object DiffCallback : DiffUtil.ItemCallback<Job>() {
        override fun areItemsTheSame(oldItem: Job, newItem: Job): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Job, newItem: Job): Boolean {
            return newItem.id == oldItem.id
        }
    }

    /**
     * ViewHolder for Groups items. All work is done by data binding.
     */
    class JobsViewHolder(val viewDataBinding: ItemJobBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root) {
        fun bind(listener: JobItemClick, job: Job) {
            viewDataBinding.item = job
            viewDataBinding.cardView = viewDataBinding.itemContainer
            viewDataBinding.itemClick = listener
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

    /**
     * Part of the RecyclerView adapter, called when RecyclerView needs a new [ViewHolder].
     *
     * A ViewHolder holds a view for the [RecyclerView] as well as providing additional information
     * to the RecyclerView such as where on the screen it was last drawn during scrolling.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobsViewHolder {
        return JobsViewHolder.from(parent)
    }

    /**
     * Part of the RecyclerView adapter, called when RecyclerView needs to show an item.
     *
     * The ViewHolder passed may be recycled, so make sure that this sets any properties that
     * may have been set previously.
     */
    override fun onBindViewHolder(holder: JobsViewHolder, position: Int) {
        holder.viewDataBinding.also {
            holder.bind(callBack, getItem(position))
        }
    }
}

/**
 * Click listener for Groups. By giving the block a name it helps a reader understand what it does.
 */
class JobItemClick(val block: (Job, Int) -> Unit) {
    /**
     * Called when a job is clicked
     * @param item the job that was clicked
     * @param version the favorite mark that was clicked
     */
    fun onClick(item: Job, version: Int) = block(item, version)
    fun onFavoriteClick(item: Job, version: Int) = block(item, version)
}