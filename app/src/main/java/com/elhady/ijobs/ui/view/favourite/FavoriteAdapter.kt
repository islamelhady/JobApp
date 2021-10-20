package com.elhady.ijobs.ui.view.favourite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.elhady.ijobs.data.model.Job
import com.elhady.ijobs.databinding.ItemFavoriteBinding
import com.elhady.ijobs.ui.view.home.JobItemClick

/**
 * Created by islam elhady on 20-Oct-21.
 */
class FavoriteAdapter(val callback: JobItemClick) :
    ListAdapter<Job, FavoriteAdapter.FavoriteViewHolder>(DiffCallback) {

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
    class FavoriteViewHolder(val viewDataBinding: ItemFavoriteBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root) {

        fun bind(listener: JobItemClick, job: Job) {
            viewDataBinding.itemClick = listener
            viewDataBinding.item = job
            viewDataBinding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): FavoriteViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemFavoriteBinding.inflate(layoutInflater, parent, false)
                return FavoriteViewHolder(binding)
            }
        }
    }

    /**
     * Part of the RecyclerView adapter, called when RecyclerView needs a new [ViewHolder].
     *
     * A ViewHolder holds a view for the [RecyclerView] as well as providing additional information
     * to the RecyclerView such as where on the screen it was last drawn during scrolling.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        return FavoriteViewHolder.from(parent)
    }

    /**
     * Part of the RecyclerView adapter, called when RecyclerView needs to show an item.
     *
     * The ViewHolder passed may be recycled, so make sure that this sets any properties that
     * may have been set previously.
     */
    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.viewDataBinding.also {
            holder.bind(callback, getItem(position))
        }
    }
}
